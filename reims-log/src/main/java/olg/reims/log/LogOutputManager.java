package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 日志输出管理器
 * 2021/6/9
 * Created by runshu.lin
 */
class LogOutputManager {

    private final int MAX_QUEUE_SIZE = 65536;

    private final int LOG_DATA_WRITE_PERIOD = 5; //秒

    private static final LogOutputManager INSTANCE = new LogOutputManager();

    public static LogOutputManager getInstance() {
        return INSTANCE;
    }

    /**
     * 异步记录日志线程池
     */
    private final ScheduledExecutorService logExecutor;

    private final ThreadPoolExecutor asyncExecutor;

    private final LinkedBlockingQueue<BaseLog> logQueue;

    private LogOutputManager() {
        this.logQueue = new LinkedBlockingQueue<>(MAX_QUEUE_SIZE);
        this.logExecutor = new ScheduledThreadPoolExecutor(1, r -> {
            Thread t = new Thread(r, "async-data-log");
            t.setDaemon(true);
            return t;
        }, new ThreadPoolExecutor.CallerRunsPolicy());
        logExecutor.scheduleAtFixedRate(() -> {
            BaseLog log = logQueue.poll();
            if (null != log) {
                try {
                    log.save();
                } catch (Exception e) {
                    this.asyncLog(e, LogLevel.ERROR.name(), log.serializeToString());
                }
            }
        }, LOG_DATA_WRITE_PERIOD, LOG_DATA_WRITE_PERIOD, TimeUnit.SECONDS);

        this.asyncExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(MAX_QUEUE_SIZE), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "async-log");
                t.setDaemon(true);
                return t;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * 异步记录日志
     */
    public <T> void asyncLog(final Throwable t, String levelName, T msg, Object... args) {
        // 日志交给异步线程池写入文件...
        Message message = MessageFactory.create(msg, levelName);
        final Logger log = LoggerFactory.getLogger(message.getLogName());
        if (null == log || !message.getLogLevel().isLogEnabled(log)) {
            return;
        }
        if (message.isForDataCenter()) {
            BaseLog baseLog = (BaseLog) message.getLogInfo();
            if (!logQueue.offer(baseLog)) {
                this.asyncLog(t, LogLevel.ERROR.name(), baseLog.serializeToString());
            }
        } else {
            asyncExecutor.execute(() -> message.getLogLevel().writeLog(log, t, (String) message.getLogInfo(), args));
        }
    }

    public void shutdown() {
        while (!logQueue.isEmpty()) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logExecutor.shutdown();
        asyncExecutor.shutdown();
    }
}

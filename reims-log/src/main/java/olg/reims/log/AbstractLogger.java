package olg.reims.log;

/**
 * 抽象的日志记录器.
 * 2021/6/9
 * Created by runshu.lin
 */
public abstract class AbstractLogger {

    /**
     * 日志输出管理器
     */
    private static final LogOutputManager OUTPUT_MANAGER = LogOutputManager.getInstance();

    /**
     * 记录日志.
     *
     * @param msg  日志信息
     * @param args 日志参数
     */
    protected void logMessage(Object msg, Object... args) {
        logMessage(null, null, msg, args);
    }

    /**
     * 记录日志.
     *
     * @param levelName 日志等级
     * @param msg       日志信息
     * @param args      日志参数
     */
    protected void logMessage(String levelName, Object msg, Object... args) {
        logMessage(null, levelName, msg, args);
    }

    /**
     * 记录日志.
     *
     * @param t         错误
     * @param levelName 日志等级
     * @param msg       日志信息
     * @param args      日志参数
     */
    protected void logMessage(Throwable t, String levelName, Object msg, Object... args) {
        OUTPUT_MANAGER.asyncLog(t, levelName, msg, args);
    }
}

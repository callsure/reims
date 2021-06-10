package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

/**
 * 2021/6/9
 * Created by runshu.lin
 */
public class MessageBaseLog implements Message {

    private final Object msg;

    private final String logName;

    private final LogLevel logLevel;

    private final boolean save;

    public MessageBaseLog(Object msg, String logName, LogLevel logLevel, boolean save) {
        this.msg = msg;
        this.logName = logName;
        this.logLevel = logLevel;
        this.save = save;
    }

    @Override
    public String getLogName() {
        return logName;
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public boolean isForDataCenter() {
        return save;
    }

    @Override
    public Object getLogInfo() {
        return msg;
    }
}

package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

/**
 * 2021/6/9
 * Created by runshu.lin
 */
public class MessageString implements Message {

    private String msg;

    private String logName;

    private LogLevel logLevel;

    public MessageString(String msg, String logName, LogLevel logLevel) {
        this.msg = msg;
        this.logName = logName;
        this.logLevel = logLevel;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
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
        return false;
    }

    @Override
    public Object getLogInfo() {
        return msg;
    }
}

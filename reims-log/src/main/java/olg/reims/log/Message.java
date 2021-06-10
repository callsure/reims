package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

/**
 * 日志消息接口
 * 2021/6/9
 * Created by runshu.lin
 */
public interface Message {

    String getLogName();

    LogLevel getLogLevel();

    boolean isForDataCenter();

    Object getLogInfo();
}

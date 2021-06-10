package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

/**
 * 日志消息工程
 * 2021/6/9
 * Created by runshu.lin
 */
public class MessageFactory {

    static Message create(Object msg, String levelName) {
        if (msg instanceof String) {
            LogLevel logLevel = LogLevel.getLogLevel(levelName);
            return new MessageString((String) msg, "COMMON_RECORD_" + logLevel.name(), logLevel);
        }
        //不是String类型，就是BaseLog类型
        DataCenterLog dataCenterLog = msg.getClass().getAnnotation(DataCenterLog.class);
        return new MessageBaseLog(msg, dataCenterLog.name(), dataCenterLog.logLevel(), dataCenterLog.isForDataCenter());
    }
}

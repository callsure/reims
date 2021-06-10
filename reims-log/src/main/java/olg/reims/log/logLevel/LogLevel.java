package olg.reims.log.logLevel;

import org.slf4j.Logger;

/**
 * 2021/6/8
 * Created by runshu.lin
 */
public enum LogLevel {
    DEBUG(Logger::debug, Logger::debug, Logger::isDebugEnabled),

    INFO(Logger::info, Logger::info, Logger::isInfoEnabled),

    WARN(Logger::warn, Logger::warn, Logger::isWarnEnabled),

    ERROR(Logger::error, Logger::error, Logger::isErrorEnabled);

    private final LogInfoIF infoIF;

    private final LogInfoWithExceptionIF infoWithExceptionIF;

    private final LogEnabledIF logEnabledIF;

    LogLevel(LogInfoIF infoIF, LogInfoWithExceptionIF infoWithExceptionIF, LogEnabledIF logEnabledIF) {
        this.infoIF = infoIF;
        this.infoWithExceptionIF = infoWithExceptionIF;
        this.logEnabledIF = logEnabledIF;
    }

    public boolean isLogEnabled(Logger logger) {
        return logEnabledIF.enabled(logger);
    }

    public void writeLog(Logger logger, Throwable t, String content, Object... args) {
        if (null == t) {
            infoIF.info(logger, content, args);
        } else {
            infoWithExceptionIF.info(logger, content, t);
        }
    }

    public static LogLevel getLogLevel(String name) {
        for (LogLevel level : values()) {
            if (level.name().equalsIgnoreCase(name)) {
                return level;
            }
        }
        return DEBUG;
    }
}

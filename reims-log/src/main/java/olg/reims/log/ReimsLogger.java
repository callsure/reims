package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

/**
 * 2021/6/9
 * Created by runshu.lin
 */
public class ReimsLogger extends AbstractLogger implements Logger {

    ReimsLogger() {
    }

    @Override
    public void debug(Object msg) {
        logMessage(msg);
    }

    @Override
    public void debug(Object msg, Object... args) {
        logMessage(msg, args);
    }

    @Override
    public void debug(Object msg, Throwable t) {
        logMessage(t, null, msg);
    }

    @Override
    public void info(Object msg) {
        logMessage(LogLevel.INFO.name(), msg);
    }

    @Override
    public void info(Object msg, Object... args) {
        logMessage(LogLevel.INFO.name(), msg, args);
    }

    @Override
    public void info(Object msg, Throwable t) {
        logMessage(t, LogLevel.INFO.name(), msg);
    }

    @Override
    public void warn(Object msg) {
        logMessage(LogLevel.WARN.name(), msg);
    }

    @Override
    public void warn(Object msg, Object... args) {
        logMessage(LogLevel.WARN.name(), msg, args);
    }

    @Override
    public void warn(Object msg, Throwable t) {
        logMessage(t, LogLevel.WARN.name(), msg);
    }

    @Override
    public void error(Object msg) {
        logMessage(LogLevel.ERROR.name(), msg);
    }

    @Override
    public void error(Object msg, Object... args) {
        logMessage(LogLevel.ERROR.name(), msg, args);
    }

    @Override
    public void error(Object msg, Throwable t) {
        logMessage(t, LogLevel.ERROR.name(), msg);
    }
}

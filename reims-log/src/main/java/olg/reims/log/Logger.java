package olg.reims.log;

/**
 * 输出日志的接口.
 * 2021/6/9
 * Created by runshu.lin
 */
public interface Logger {

    /**
     * 输出一条Debug级别的日志.
     */
    void debug(Object msg);

    /**
     * 输出一条Debug级别的日志.
     */
    void debug(Object msg, Object... args);

    /**
     * 输出一条Debug级别的日志.
     */
    void debug(Object msg, Throwable t);

    /**
     * 输出一条Info级别的日志.
     */
    void info(Object msg);

    /**
     * 输出一条Info级别的日志.
     */
    void info(Object msg, Object... args);

    /**
     * 输出一条Info级别的日志.
     */
    void info(Object msg, Throwable t);

    /**
     * 输出一条Warn级别的日志.
     */
    void warn(Object msg);

    /**
     * 输出一条Warn级别的日志.
     */
    void warn(Object msg, Object... args);

    /**
     * 输出一条Warn级别的日志.
     */
    void warn(Object msg, Throwable t);

    /**
     * 输出一条Error级别的日志.
     */
    void error(Object msg);

    /**
     * 输出一条Error级别的日志.
     */
    void error(Object msg, Object... args);

    /**
     * 输出一条Error级别的日志.
     */
    void error(Object msg, Throwable t);
}

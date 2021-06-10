package olg.reims.log.logLevel;

import org.slf4j.Logger;

/**
 * 2021/6/8
 * Created by runshu.lin
 */
@FunctionalInterface
public interface LogInfoWithExceptionIF {
    void info(Logger logger, String info, Throwable t);
}

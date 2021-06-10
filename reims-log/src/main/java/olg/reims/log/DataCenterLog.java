package olg.reims.log;

import olg.reims.log.logLevel.LogLevel;

import java.lang.annotation.*;

/**
 * 标志日志数据类
 * 2021/6/9
 * Created by runshu.lin
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataCenterLog {

    /**
     * 日志名
     */
    String name();

    /**
     * 是否存库
     */
    boolean isForDataCenter() default true;

    /**
     * 日志等级
     */
    LogLevel logLevel() default LogLevel.DEBUG;
}

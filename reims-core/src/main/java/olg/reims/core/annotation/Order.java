package olg.reims.core.annotation;

import java.lang.annotation.*;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Order {

    /**
     * 用于排序的具体数值.
     * <p>
     * 数值越小排序越靠前，负数也遵循这个规则
     *
     * @return 排序值
     */
    int value();
}

package olg.reims.core.annotation;

import java.lang.annotation.*;

/**
 * 2021/6/9
 * Created by runshu.lin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String[] value() default {};
}

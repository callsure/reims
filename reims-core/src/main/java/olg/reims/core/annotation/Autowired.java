package olg.reims.core.annotation;

import java.lang.annotation.*;

/**
 * 2021/6/9
 * Created by runshu.lin
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

    boolean required() default true;

}

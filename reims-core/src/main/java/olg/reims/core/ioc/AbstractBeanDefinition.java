package olg.reims.core.ioc;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

    private volatile Object beanClass;

    private String[] dependsOn;

}

package olg.reims.core.ioc;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public interface BeanDefinition {

    String getBeanClassName();

    void setBeanClassName(String beanClassName);

    void setDependsOn(String... dependsOn);

    String[] getDependsOn();
}

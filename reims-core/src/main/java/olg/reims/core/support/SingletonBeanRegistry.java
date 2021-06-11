package olg.reims.core.support;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public interface SingletonBeanRegistry {

    String[] getSingletonNames();

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}

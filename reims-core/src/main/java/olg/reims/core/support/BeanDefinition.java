package olg.reims.core.support;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public interface BeanDefinition {

    String[] getBeanName();

    void injection(IocMaking making);
}

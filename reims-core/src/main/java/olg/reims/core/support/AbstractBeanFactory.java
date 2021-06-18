package olg.reims.core.support;

import olg.reims.core.exception.BeanCreationException;
import olg.reims.core.exception.BeansException;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
public abstract class AbstractBeanFactory {

    protected abstract boolean containsBeanDefinition(String beanName);

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, Object[] args) throws BeanCreationException;
}

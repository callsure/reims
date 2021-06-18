package olg.reims.core.support;

import olg.reims.core.exception.BeanCreationException;
import olg.reims.core.exception.BeansException;
import olg.reims.core.support.definition.DefaultBeanDefinition;
import olg.reims.core.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static olg.reims.log.LogHelper.logger;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
public class DefaultBeanFactory extends AbstractBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    private final List<BeanDefinition> configurations = new ArrayList<>();

//    private final List<StaticComponentBeanDefinition> staticComponents = new ArrayList<>();

    @Override
    protected boolean containsBeanDefinition(String beanName) {
        return this.beanDefinitionMap.containsKey(beanName);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return this.beanDefinitionMap.get(beanName);
    }

    @Override
    protected Object createBean(String beanName, Object[] args) throws BeanCreationException {
        DefaultBeanDefinition mbdToUse = new DefaultBeanDefinition();
        Class<?> resolvedClass = resolveBeanClass(mbdToUse, beanName);
        mbdToUse.setBeanClass(resolvedClass);

        // Prepare method overrides.
        try {
            mbdToUse.prepareMethodOverrides();
        } catch (BeanDefinitionValidationException ex) {
            throw new BeanDefinitionStoreException(mbdToUse.getResourceDescription(),
                    beanName, "Validation of method overrides failed", ex);
        }

        try {
            // Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
            Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
            if (bean != null) {
                return bean;
            }
        } catch (Throwable ex) {
            throw new BeanCreationException(mbdToUse.getResourceDescription(), beanName,
                    "BeanPostProcessor before instantiation of bean failed", ex);
        }

        try {
            Object beanInstance = doCreateBean(beanName, mbdToUse, args);
            logger.debug("Finished creating instance of bean '" + beanName + "'");
            return beanInstance;
        } catch (BeanCreationException | ImplicitlyAppearedSingletonException ex) {
            // A previously detected exception with proper bean creation context already,
            // or illegal singleton state to be communicated up to DefaultSingletonBeanRegistry.
            throw ex;
        } catch (Throwable ex) {
            throw new BeanCreationException(
                    mbdToUse.getResourceDescription(), beanName, "Unexpected exception during bean creation", ex);
        }
    }

    protected Class<?> resolveBeanClass(DefaultBeanDefinition mbd, String beanName) {
        if (mbd.hasBeanClass()) {
            return mbd.getBeanClass();
        }
        return ClassUtils.loadClass(beanName);
    }
}

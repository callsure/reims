package olg.reims.core.support;

import olg.reims.core.support.definition.DefaultBeanDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
public class IocMaking implements AutoCloseable {

    private final DefaultSingletonBeanRegistry registry;

    private final Map<Class<?>, List<DefaultBeanDefinition>> interfaceImplCache = new HashMap<>();

    IocMaking(DefaultSingletonBeanRegistry registry) {
        this.registry = registry;
    }

    public DefaultSingletonBeanRegistry getSingletonBeanRegistry() {
        return registry;
    }

    public List<DefaultBeanDefinition> findAllImpl(Class<?> interfaceClass) {
        return interfaceImplCache.computeIfAbsent(interfaceClass, registry::findImpl);
    }

    @Override
    public void close() throws Exception {
        interfaceImplCache.clear();
    }
}

package olg.reims.core.support;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2021/6/11
 * Created by runshu.lin
 */
public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);

    private final Set<String> registeredSingletons = new LinkedHashSet<>(256);

    private final Set<String> singletonsCurrentlyInCreation = Collections.newSetFromMap(new ConcurrentHashMap<>(16));

    private final Set<String> inCreationCheckExclusions = Collections.newSetFromMap(new ConcurrentHashMap<>(16));
}

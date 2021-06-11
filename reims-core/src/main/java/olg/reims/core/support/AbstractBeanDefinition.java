package olg.reims.core.support;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

    private volatile Object beanClass;

    private String[] dependsOn;


    public AbstractBeanDefinition() {
        this(null, null);
    }

    public AbstractBeanDefinition(Object beanClass, String[] dependsOn) {
        this.beanClass = beanClass;
        this.dependsOn = dependsOn;
    }


    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClass = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        } else {
            return (String) beanClassObject;
        }
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() throws IllegalStateException {
        Object beanClassObject = this.beanClass;
        if (beanClassObject == null) {
            throw new IllegalStateException("No bean class specified on bean definition");
        }
        if (!(beanClassObject instanceof Class)) {
            throw new IllegalStateException(
                    "Bean class name [" + beanClassObject + "] has not been resolved into an actual Class");
        }
        return (Class<?>) beanClassObject;
    }

    public boolean hasBeanClass() {
        return (this.beanClass instanceof Class);
    }

//    public Class<?> resolveBeanClass( ClassLoader classLoader) throws ClassNotFoundException {
//        String className = getBeanClassName();
//        if (className == null) {
//            return null;
//        }
//        Class<?> resolvedClass = ClassUtils.forName(className, classLoader);
//        this.beanClass = resolvedClass;
//        return resolvedClass;
//    }
}

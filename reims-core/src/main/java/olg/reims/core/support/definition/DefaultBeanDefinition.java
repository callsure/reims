package olg.reims.core.support.definition;

import cn.hutool.core.util.StrUtil;
import olg.reims.core.annotation.Component;
import olg.reims.core.annotation.Order;
import olg.reims.core.support.BeanDefinition;
import olg.reims.core.utils.ClassUtils;
import org.reims.asm.MethodAccess;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * 2021/6/10
 * Created by runshu.lin
 */
public class DefaultBeanDefinition implements BeanDefinition {

    private static final Set<Class<?>> IGNORE_ANNOTATION_BY_METHODS = new HashSet<>();

    static {
        IGNORE_ANNOTATION_BY_METHODS.add(Deprecated.class);
    }

    protected final Object single;
    protected final MethodAccess methodAccess;
    protected final HashMap<Class<? extends Annotation>, List<MethodDefinition>> customMethods = new HashMap<>();
    private final Class<?> beanClass;
    private String beanName = "";

    private Annotation annotation;
    private Class<? extends Annotation> annotationType;

    /**
     * 注入排序值
     */
    private final int order;

    private final ArrayList<FieldDefinition> autowiredFields = new ArrayList<>();

    public DefaultBeanDefinition(Class<?> klass) {
        this(klass, ClassUtils.newInstance(klass));
    }

    public DefaultBeanDefinition(String beanName, Object object) {
        this(object.getClass(), object);
        this.beanName = beanName;
    }

    public DefaultBeanDefinition(Class<?> klass, Object object) {
        this.single = object;
        this.beanClass = klass;
        this.methodAccess = MethodAccess.get(beanClass);

        Order order = beanClass.getAnnotation(Order.class);
        this.order = order == null ? Integer.MAX_VALUE : order.value();
    }

    public DefaultBeanDefinition(Class<?> klass, Annotation annotation, Class<? extends Annotation> annotationType) {
        this(klass, ClassUtils.newInstance(klass));
        this.annotation = annotation;
        this.annotationType = annotationType;
    }

    public DefaultBeanDefinition init() {
        this.analysisField();
        this.analysisMethod();
        return this;
    }

    @Override
    public String[] getBeanName() {
        if (annotationType == Component.class) {
            return ((Component) annotation).value();
        }

        // 有指定名称使用指定名称
        if (StrUtil.isNotEmpty(beanName)) {
            return new String[]{beanName};
        }

        return new String[]{beanClass.getName()};
    }
}

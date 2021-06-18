package olg.reims.core.utils;

import olg.reims.core.exception.ServerBootstrapException;

import java.lang.reflect.InvocationTargetException;

/**
 * 2021/6/17
 * Created by runshu.lin
 */
public class ClassUtils {

    /**
     * 使用当前线程的ClassLoader加载给定的类
     *
     * @param className 类的全称
     * @return 给定的类
     */
    public static Class<?> loadClass(String className) {
        // ClassLoader#loadClass(String)：将.class文件加载到JVM中，不会执行static块,只有在创建实例时才会去执行static块
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException ignored) {
        }

        // Class#forName(String)：将.class文件加载到JVM中，还会对类进行解释，并执行类中的static块
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ignored) {
        }

        throw new ServerBootstrapException("无法加载指定类名的Class=" + className);
    }

    /**
     * 创建一个指定类的对象,调用默认的构造函数.
     *
     * @param <T>   Class
     * @param klass 类
     * @return 指定类的对象
     */
    public static <T> T newInstance(final Class<T> klass) {
        try {
            return klass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ServerBootstrapException("无法创建实例. Class=" + klass.getName(), e);
        }
    }

}

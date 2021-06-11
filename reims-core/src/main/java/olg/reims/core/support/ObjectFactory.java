package olg.reims.core.support;

/**
 * 2021/6/11
 * Created by runshu.lin
 */
@FunctionalInterface
public interface ObjectFactory<T> {
    T getObject() throws RuntimeException;
}

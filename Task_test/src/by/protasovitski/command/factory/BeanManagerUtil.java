package by.protasovitski.command.factory;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

public class BeanManagerUtil {
    @Inject
    private BeanManager beanManager;

    @SuppressWarnings("unchecked")
    public <T> DestructibleBeanInstance<T> getDestructibleBeanInstance(final Class<T> type,
                                                                       final Annotation... qualifiers) {

        DestructibleBeanInstance<T> result = null;
        Bean<T> bean = (Bean<T>) beanManager.resolve(beanManager.getBeans(type, qualifiers));
        if (bean != null) {
            CreationalContext<T> creationalContext = beanManager.createCreationalContext(bean);
            if (creationalContext != null) {
                T instance = bean.create(creationalContext);
                result = new DestructibleBeanInstance<T>(instance, bean, creationalContext);
            }
        }
        return result;
    }
}

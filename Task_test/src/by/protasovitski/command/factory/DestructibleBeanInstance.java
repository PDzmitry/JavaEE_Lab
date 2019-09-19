package by.protasovitski.command.factory;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;

public class DestructibleBeanInstance<T> {
    private T instance;
    private Bean<T> bean;
    private CreationalContext<T> context;

    public DestructibleBeanInstance(T instance, Bean<T> bean, CreationalContext<T> context) {
        this.instance = instance;
        this.bean = bean;
        this.context = context;
    }

    public T getInstance() {
        return instance;
    }

    public void destroy() {
        bean.destroy(instance, context);
    }
}

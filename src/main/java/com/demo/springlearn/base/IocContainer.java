package com.demo.springlearn.base;

import com.demo.springlearn.aspect.AdviceInvocationHandler;
import com.demo.springlearn.aspect.Aspect;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class IocContainer {

    private static Map<String, Object> beanMap = new HashMap<String, Object>();

    private Aspect aspect;

    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }

    public  void beanDefinition(String beanName, Class<?> beanClass) {
        try {
            beanMap.put(beanName, beanClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public  Object getBean(String beanName) {
        return createBean(beanName);
    }

    private Object createBean(String beanName) {
        final Object bean = beanMap.get(beanName);
        if (aspect != null && bean.getClass().getName().matches(aspect.getJoinPoint().getClassPattern())) {
            return proxyBean(bean);
        }
        return bean;
    }

    private Object proxyBean(Object bean) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),bean.getClass().getInterfaces(),new AdviceInvocationHandler(aspect,bean));
    }
}

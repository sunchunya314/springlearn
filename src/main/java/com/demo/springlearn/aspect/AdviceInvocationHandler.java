package com.demo.springlearn.aspect;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AdviceInvocationHandler implements InvocationHandler {

    private Aspect aspect;

    private Object target;

    public AdviceInvocationHandler(Aspect aspect, Object target) {
        this.aspect = aspect;
        this.target =target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 检验方法匹配
        if (aspect != null && method.getName().matches(aspect.getJoinPoint().getMethodPattern())) {
            return this.aspect.getAdvice().around(target, method, args);
        }
        return method.invoke(target,args);
    }
}

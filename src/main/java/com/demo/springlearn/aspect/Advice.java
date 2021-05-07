package com.demo.springlearn.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Advice {

    Object around(Object target, Method method, Object[] args) throws Exception;
}

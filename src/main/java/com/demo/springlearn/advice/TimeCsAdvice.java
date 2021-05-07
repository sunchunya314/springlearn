package com.demo.springlearn.advice;

import com.demo.springlearn.aspect.Advice;

import java.lang.reflect.Method;

/**
 * 统计时间增强
 */
public class TimeCsAdvice implements Advice {

    public Object around(Object target, Method method, Object[] args) throws Exception {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        System.out.println(args[0]+" "+method.getName()+ " 花费了时间: "+(System.currentTimeMillis()-start));
        return result;
    }
}

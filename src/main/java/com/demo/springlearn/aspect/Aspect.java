package com.demo.springlearn.aspect;

public class Aspect {

    private Advice advice;

    private JoinPoint joinPoint;

    public Aspect(Advice advice, JoinPoint joinPoint) {
        this.advice = advice;
        this.joinPoint = joinPoint;
    }

    public Advice getAdvice() {
        return advice;
    }

    public JoinPoint getJoinPoint() {
        return joinPoint;
    }
}

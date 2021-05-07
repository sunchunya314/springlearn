package com.demo.springlearn.aspect;

public class JoinPoint {

    private String classPattern;

    private String methodPattern;

    public JoinPoint(String classPattern, String methodPattern) {
        this.classPattern = classPattern;
        this.methodPattern = methodPattern;
    }

    public String getClassPattern() {
        return classPattern;
    }

    public String getMethodPattern() {
        return methodPattern;
    }
}

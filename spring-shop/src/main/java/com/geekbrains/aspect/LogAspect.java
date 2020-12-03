package com.geekbrains.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Around("@annotation(log)")
    protected Object logAround(ProceedingJoinPoint p, Log log) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = p.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(p.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    };

}

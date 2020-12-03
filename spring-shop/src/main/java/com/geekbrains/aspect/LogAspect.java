package com.geekbrains.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    private final LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
    private final ExpressionParser parser = new SpelExpressionParser();
   /* @Before("@annotation(log)")
    protected Object logBefore(Log log) {
        System.out.println("log Before");
        return null;
    };
*/
    @Around("@annotation(log)")
    protected Object logAround(ProceedingJoinPoint p, Log log) throws Throwable {
        System.out.println("Зашли в around");
        System.out.println("log Before");
        System.out.println(getValue(log.message(), ((MethodSignature)p.getSignature()).getMethod(), p.getArgs(), String.class));
        p.proceed();
        System.out.println("log After");
        return p;
    };

    private Object getValue (String spel, Method method, Object[] args, Class<String> type ) {
        if (StringUtils.isEmpty(spel)) {
            return null;
        }
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for(int len=0; len<params.length; len++) {
          context.setVariable(params[len], args[len]);
        }

        Expression expression = parser.parseExpression(spel);
        return expression.getValue(context, type);
    }
  /*  @After("@annotation(log)")
    protected Object logAfter(Log log) {
        System.out.println("log After");
        return null;
    };*/
}

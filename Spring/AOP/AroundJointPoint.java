package com.practice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Order(value = 0)
@Component
public class TraceableAspect {

    @Around("@annotation(com.practice.annotation.Traceable)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Logger log = LoggerFactory.getLogger(point.getSignature().getDeclaringType());
        
        if (log.isDebugEnabled()) {
            log.debug(point.getSignature().toShortString() + " with args: {}", (Object) point.getArgs());
        } else {
            log.info(point.getSignature().toShortString());
        }

        long start = System.currentTimeMillis();
        try {
            Object proceed = point.proceed();
            long executionTime = System.currentTimeMillis() - start;
            if (log.isDebugEnabled()) {
                log.debug("{} executed in {}ms, result: [{}]",
                        point.getSignature().toShortString(), executionTime, result(proceed));
            } else {
                log.info("{} executed in {}ms.",
                        point.getSignature().toShortString(), executionTime);
            }
            return proceed;
        } catch (Exception ex) {
            log.info(point.getSignature().toShortString() + " failed", ex);
            throw ex;
        }
    }

    private static Object result(Object obj) {
        if (obj == null) {
            return "null";
        } else if (obj instanceof Collection) {
            return "collection size: " + ((Collection) obj).size();
        } else if (obj.getClass().isArray()) {
            return "array length: " + ((Object[]) obj).length;
        } else return obj;
    }
}

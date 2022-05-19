package com.ilyassov.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Log
public class UserAspect {

    @Pointcut("@annotation(AopToken)")
    public void tokenProcessingMethods() {
    }


    @Around("tokenProcessingMethods()")
    public Object ExecTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        long time = System.currentTimeMillis() - startTime;

        log.info(point.getSignature() + ".Finished in " + time + "ms");
        return proceed;
    }

    @AfterThrowing(pointcut = "@annotation(com.ilyassov.aop.AopToken)", throwing = "ex")
    public void WithinException(JoinPoint joinPoint, Exception ex) {
        log.info("Exception in " + joinPoint.getSignature() + ", " + ex.getMessage());
    }

    @Before("tokenProcessingMethods()")
    public void meBefore(JoinPoint point) {
        log.info("Method name: " + point.getSignature().getName() + " .Time: " + new Date().getTime());
    }


    @After("tokenProcessingMethods()")
    public void meAfter(JoinPoint point) {
        log.info("Method name: " + point.getSignature().getName() + " .Time: " + new Date().getTime());
    }

    @AfterReturning(pointcut = "execution(public * com.ilyassov.service.UserService.getUsers())", returning = "result")
    public void checkAllUsers(JoinPoint point, Object result) {
        log.info("Method name: " + point.getSignature().getName() + ". Result: ");
        log.info(result.toString());
    }
}
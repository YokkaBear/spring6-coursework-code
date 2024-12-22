package com.cicc.itgm.springAop.xmlAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

// 切面类
@Component("logAspectXml") // 通过Spring IOC管理bean对象
public class LogAspect {
    // 前置通知
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 前置通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args));
    }

    // 后置通知
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 后置通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args));
    }

    // 返回通知
    public void afterReturningMethod(JoinPoint joinPoint, Object returnResult) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 返回通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args) + "；方法返回：" + returnResult);
    }

    // 异常通知
    // 目标方法出现异常，执行此通知 类似于try..catch..finally中的finally部分
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 异常通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args) + "；异常类型：" + ex);
    }

    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知 - 方法执行前通知");
            System.out.println("环绕通知 - 方法名称：" + methodName + "；参数值：" + Arrays.toString(args));
            result = joinPoint.proceed();
            System.out.println("环绕通知 - 方法执行后通知");
        } catch (Throwable throwable) {
            System.out.println("环绕通知 - 方法抛出异常时通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知 - 方法执行全部完毕后通知");
        }
        return result;
    }
}

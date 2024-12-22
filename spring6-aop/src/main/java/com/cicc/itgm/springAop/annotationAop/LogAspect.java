package com.cicc.itgm.springAop.annotationAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 切面类
@Component // 表示springIOC中进行管理
@Aspect // 表示切面类
public class LogAspect {
    // 设置切入点和通知类型
    // 通知类型：前置 返回 异常 后置 环绕

    // 前置通知
//    @Before(value = "execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.*(..))")
//    @Before(value = "com.cicc.itgm.springAop.annotationAop.LogAspect.pointCut()") // 不同切面 需要加上切面类的全类名
    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 前置通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args));
    }

    // 后置通知
    @After(value = "execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 后置通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args));
    }

    // 返回通知
    @AfterReturning(value = "execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.add(int, int))", returning = "returnResult")
    public void afterReturningMethod(JoinPoint joinPoint, Object returnResult) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 返回通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args) + "；方法返回：" + returnResult);
    }

    // 异常通知
    // 目标方法出现异常，执行此通知 类似于try..catch..finally中的finally部分
    @AfterThrowing(value = "execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.div(int, int))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger - 异常通知；方法名称：" + methodName + "；参数值：" + Arrays.toString(args) + "；异常类型：" + ex);
    }

    // 环绕通知
    // 手动设置方法在try..catch..finally整个过程中的执行计划
    @Around(value = "execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.mul(int, int))")
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

    // 复用切入点表达式
    // 通过定义切入点方法 避免编写重复代码
    @Pointcut("execution(* com.cicc.itgm.springAop.annotationAop.CalculatorImpl.*(..))")
    public void pointCut() {}

}

package cn.com.mine.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyInterceptor {
    @Pointcut("execution (* cn.com.mine.springaop.HelloWorldImpl3.*(..))")
    private void anyMethod() {} // 声明一个切入点，anyMethod为切入点名称

    // 声明该方法是一个前置通知：在目标方法开始之前执行 
    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrowing() {
        System.out.println("异常通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        /**
         * 环绕通知内部一定要确保执行该方法，如果不执行该方法，业务bean中被拦截的方法就不会被执行。
         * 当执行该方法，如果后面还有切面的话，它的执行顺序应该是这样的：先执行后面的切面，如果后面没有切面了，
         * 再执行最终的目标对象的业务方法。若不执行该方法，则后面的切面，业务bean的方法都不会被执行。
         */
        // if () { // 判断用户是否有权限，
        System.out.println("进入方法");
        Object result = pjp.proceed();
        System.out.println("退出方法");
        // }
        return result;
    }
}

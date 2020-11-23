package com.myy.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 切入点: 管理切入点的,当有重复的切入点表达式时,可以简写为:@Before("myPT()")
     */
    @Pointcut("execution(public * com.myy.service..*.doSome*(..))")
    private void myPT(){

    }



    /**
     * 前置通知
     *
     * @param jp JoinPoint必须是在所有参数的第一位
     */
    @Before("execution(public * com.myy.service..*.doSome*(..))")
    public void doBefore(JoinPoint jp) {
        System.out.println("-----前置通知代码执行-----");
        System.out.println("连接点签名:" + jp.getSignature());
        System.out.println("连接点方法名:" + jp.getSignature().getName());
        for (Object o : jp.getArgs()) {
            System.out.println("连接点的参数:" + o);
        }
        System.out.println("-----前置通知结束-----");
    }

    /**
     * 后置通知
     *
     * @param jp 同上
     */
    @After("execution(public * com.myy.service..*.doSome*(..))")
    public void doAfter(JoinPoint jp) {
        System.out.println("-----后置通知代码执行-----");
        System.out.println("-----后置通知结束-----");
    }

    /**
     * doSome方法返回结果时通知
     * String类型的无法改变返回值类型,而对象类型的可以调用set方法将返回值属性改变
     * @param rtn doSome*方法的返回对象
     */
    @AfterReturning(value = "execution(public * com.myy.service..*.doSome*(..))", returning = "rtn")
    public void doAfterReturning(Object rtn) {
        System.out.println("-----@AfterReturning通知代码执行-----");
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.myy.service..*.doSome*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-----环绕通知代码执行-----");
        // 相当于method.invoke()
        Object result = pjp.proceed();
        // 对结果进行处理
        System.out.println("-----环绕通知结束并返回结果-----");
        if (result instanceof Integer){
            return result = (Integer)result + 100;
        }
        if (result instanceof String){
            return result = (String)result + "@Around";
        }
        return result;
    }

   /* @AfterThrowing(value = "execution(public * com.myy.service..*.doSome*(..))")
    public void doAfterThrowing(Object obj){
    }*/




}

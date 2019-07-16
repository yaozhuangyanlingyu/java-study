package com.spring.aop.advice;

public class TransactionAdvice {

	// 前置通知：在目标方法之前调用
	public void before() {
		System.out.println("前置通知被执行");
	}

	// 后置通知：(如果出现异常就不调用)，在目标方法之后调用
	public void afterReturning() {
		System.out.println("后置通知被执行，出现异常不调用");
	}

	// 后置通知：(无论是否出现异常都会调用)：在目标方法之后调用
	public void after() {
		System.out.println("后置通知被执行，无论是否出现异常都会调用");
	}

	// 环绕通知：在目标方法之前、后调用
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("");
		joinPoint.proceed();			// 调用目标方法
		System.out.println("");
	}

	// 异常通知：出现异常则调用
	public void afterException() {
		System.out.println("异常通知被执行");
	}
}

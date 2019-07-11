package com.ariba.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeProfilerAspect {

	@Around("execution(* com.ariba.training.service.ProductService.*(..))")
	public Object calcualteTime(ProceedingJoinPoint actualMethod) throws Throwable{
		long start = System.currentTimeMillis();
		Object returnFromActual = actualMethod.proceed();
		long stop = System.currentTimeMillis();
		System.out.println("["+actualMethod.getSignature().toShortString()+" took "+(stop -start)+" ms.]");
		return returnFromActual;
	}
	
}

package com.rise.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	

	@Around("execution(* com.encore.service.MsgService*.*(..))")//Before+After
	public Object startEndLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("===============<�� Before>==================");
		long start = System.currentTimeMillis();
		//���� �ٽɸ޼ҵ� ȣ��!! 
		Object result = joinPoint.proceed();
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("["+joinPoint.getSignature().getName()+
				        "]�޼ҵ� ����ð�: "+ (end-start));
		System.out.println("===============<�� After>==================");
		
		return result;
	}

}

package com.test.jpa.loggingAspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public LoggingAspect() {
		super();
	}
	
	@Before("execution(* com.test.jpa..*.*(..))")
	public void before(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		
		
		Object[] args = joinPoint.getArgs();
		
		logger.info("before()");
		
	}

}

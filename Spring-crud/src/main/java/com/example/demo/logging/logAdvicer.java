package com.example.demo.logging;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class logAdvicer {
	
	Logger log = LoggerFactory.getLogger(logAdvicer.class);
	
	
	
	@Pointcut(value="execution(* com.example.demo.controller.ProductController.addProduct(..) )")
	public void myPointCut()
	{
		//AspectJProxyFactory factory = new AspectJProxyFactory(targetObject);
	}
	
	@Pointcut(value="execution(* com.example.demo.controller.ProductController.addProducts(..) )")
	public void myPointCut1()
	{
		 
	}
			
	@After("myPointCut()")	
	public void applicationLogger(JoinPoint  jop) throws Throwable
	{
		ObjectMapper mapper = new ObjectMapper();
		String methodname = jop.getSignature().getName();
		String classname = jop.getTarget().getClass().getName();
		Object args[] = jop.getArgs();		
		log.info("Before***>[Methos invoked]"+methodname+"[class Name]"+classname+"[Args]"+mapper.writeValueAsString(args));
		log.info("Info Logging");
		log.debug("debug Logging");
		log.trace("trace Logging");
		log.warn("warn Logging");
		log.error("error Logging");
	}
	
	
	@Around("myPointCut()")	
	public Object applicationLogger1(ProceedingJoinPoint jop) throws Throwable
	{

		
		ObjectMapper mapper = new ObjectMapper();
		String methodname = jop.getSignature().getName();
		String classname = jop.getTarget().getClass().getName();
		Object args[] = jop.getArgs();		
		log.info("Before=>[Methos invoked]"+methodname+"[class Name]"+classname+"[Args]"+mapper.writeValueAsString(args));
		
		Object res = jop.proceed();
		
		log.info("After=>[Methos invoked]"+methodname+"[class Name]"+classname+"[Response]"+mapper.writeValueAsString(res));
		
		return res;
		
	}

}

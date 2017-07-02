package org.jiang.COC.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//@Component
//@Aspect
public class AOP {
//	@Pointcut("execution(* org.jiang.COC.controller.PushInfoController.savepushInfo(..,String))")
//	public void enter(){}
	
	
	public void before(String content){
		System.out.println(content);
	}
}

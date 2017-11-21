package com.toeic.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Aspect
@Log
public class TimeChecker {

	@Before("execution(* com.toeic.mapper.*.*(..))")
	public void checkTime(JoinPoint jp) {
		log.info("Method Excute Time: " + System.currentTimeMillis());
		log.info("JoinPoint's Args: " + Arrays.toString(jp.getArgs()));
		//메소드가 실행될 때의 시간과 메소드의 Parameter를 출력
	}
	
}

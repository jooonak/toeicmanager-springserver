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
		//�޼ҵ尡 ����� ���� �ð��� �޼ҵ��� Parameter�� ���
	}
	
}

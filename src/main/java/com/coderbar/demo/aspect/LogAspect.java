package com.coderbar.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//ポイント１：@Aspect
@Aspect
@Component
public class LogAspect {
//ポイント２：AOPの実装
	@Before("execution(* *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド開始： " + jp.getSignature());
	}

//ポイント２：AOPの実装
	@After("execution(* *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("メソッド終了： " + jp.getSignature());
	}
	
}
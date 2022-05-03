package com.coderbar.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//ポイント１：@Aspect
@Aspect
@Component
public class ErrorAspect {
//	@Around("execution(* *..*.*Controller.*(..))")
//	public Object startLog(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("メソッド開始： " + jp.getSignature());
//		try { // ポイント２：メソッド実行
//			Object result = jp.proceed();
//			System.out.println("メソッド終了： " + jp.getSignature());
//			return result;
//		} catch (Exception e) {
//			System.out.println("メソッド異常終了： " + jp.getSignature());
//			e.printStackTrace();
//			throw e;
//		}
//	}

	// annotation
	/*
	 * @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	 * public Object startLog2(ProceedingJoinPoint jp) throws Throwable {
	 * System.out.println("メソッド2開始： " + jp.getSignature()); try { // ポイント２：メソッド実行
	 * Object result = jp.proceed(); System.out.println("メソッド2終了： " +
	 * jp.getSignature()); return result; } catch (Exception e) {
	 * System.out.println("メソッド2異常終了： " + jp.getSignature()); e.printStackTrace();
	 * throw e; } }
	 */
	// ポイント：@within
	/*
	 * @Around("@within(org.springframework.stereotype.Controller)") public Object
	 * startLog3(ProceedingJoinPoint jp) throws Throwable {
	 * System.out.println("メソッド開始： " + jp.getSignature()); try { // ポイント２：メソッド実行
	 * Object result = jp.proceed(); System.out.println("メソッド終了： " +
	 * jp.getSignature()); return result; } catch (Exception e) {
	 * System.out.println("メソッド異常終了： " + jp.getSignature()); e.printStackTrace();
	 * throw e; } }
	 */
	/*
	 * @AfterThrowing(value="execution(* *..*.*Controller.*(..))") public void
	 * throwingNull(DataAccessException ex) {
	 * System.out.println("==================================================");
	 * System.out.println("DataAccessException発生しました"+ex);
	 * System.out.println("=================================================="); }
	 */
}

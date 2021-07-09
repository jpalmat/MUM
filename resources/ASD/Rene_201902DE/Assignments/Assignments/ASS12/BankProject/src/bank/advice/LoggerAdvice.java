package bank.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAdvice {
	@After("execution(* bank.dao.AccountDAO.*(..))")
	public void logAfterAdvice(JoinPoint joinPoint) {
		System.out.println("DAO Operation Executed = "+joinPoint.getSignature().getName());
	}
}

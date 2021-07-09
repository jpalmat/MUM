package bank.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAdvice {
	@Around("execution(* bank.service.AccountService.*(..))")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(joinPoint.getSignature().getName());
		Object retVal = joinPoint.proceed();
		sw.stop();
		long elapsedTime = sw.getLastTaskTimeMillis();
		System.out.println("Operation "+joinPoint.getSignature().getName()+" execution Time = "+elapsedTime+" ms");
		return retVal;
	}
}

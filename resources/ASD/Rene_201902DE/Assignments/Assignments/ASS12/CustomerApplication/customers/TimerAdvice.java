package customers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAdvice {
	@Around("execution(*  customers.CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable{
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		
		long elapsedTime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save = "+elapsedTime+" ms");
		return retVal;
	}
}

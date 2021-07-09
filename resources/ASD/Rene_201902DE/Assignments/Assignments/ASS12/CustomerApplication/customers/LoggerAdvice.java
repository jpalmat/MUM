package customers;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAdvice {
	@After("execution(* customers.EmailSender.sendEmail(..)) && args(email,message)")
	public void logAfterMethod(JoinPoint joinpoint, String email, String message) {
		EmailSender emailSender = (EmailSender) joinpoint.getTarget();
		System.out.println(new Date().toString() + " method= " + joinpoint.getSignature().getName() + " address=" + email);
		System.out.println("message= " + message);
		System.out.println("outgoing mail server = "+emailSender.outgoingMailServer);
	}
}

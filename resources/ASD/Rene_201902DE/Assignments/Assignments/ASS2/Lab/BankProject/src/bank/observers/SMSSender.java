package bank.observers;


public class SMSSender implements Observer {
	private String sms = "SMS sent : ";

	public void update(Object arg) {
		// TODO Auto-generated method stub
		System.out.println(sms+arg);
	}
	

}

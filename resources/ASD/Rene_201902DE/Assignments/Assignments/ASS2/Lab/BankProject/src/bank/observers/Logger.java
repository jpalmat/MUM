package bank.observers;


public class Logger implements Observer {
	private String log = "Logger : ";

	public void update(Object arg) {
		// TODO Auto-generated method stub
		System.out.println(log+arg);
	}
	

}

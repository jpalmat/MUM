package bank.observers;


public class EmailSender implements Observer {
	private String email = "email sent : ";

	public void update(Object arg) {
		// TODO Auto-generated method stub
		System.out.println(email+arg);
	}
	

}

package bank.domain;

public class SavingsAccount implements InterestBehaviour {

	public double addInterest(double balance) {
		// TODO Auto-generated method stub
		if (balance < 1000)
			return balance * .01;
		else if (balance < 5000)
			return balance * .02;
		else
			return balance * .04;
	}

}

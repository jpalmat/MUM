package bank.domain;

public class CheckingsAccount implements InterestBehaviour {

	public double addInterest(double balance) {
		// TODO Auto-generated method stub
			if (balance<1000)
				return balance*.015;
			else
				return balance*.025;
	}

}

package bank.dao;

public class FactoryDAO {

	public static enum ACCOUNT_TYPE {
		ACCOUNT, MOCK;
	}

	public static IAccountDAO createDAO(ACCOUNT_TYPE type) {
		IAccountDAO dao = null;
		if (type.equals(ACCOUNT_TYPE.ACCOUNT)) {
			dao = new AccountDAO();
		} else if (type.equals(ACCOUNT_TYPE.MOCK)) {
			dao = new MockAccountDAO();
		}
		return dao;
	}
}

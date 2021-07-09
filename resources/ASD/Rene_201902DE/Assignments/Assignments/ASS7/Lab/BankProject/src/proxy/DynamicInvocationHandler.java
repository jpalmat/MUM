package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import bank.dao.IAccountDAO;
import bank.domain.Account;

public class DynamicInvocationHandler implements InvocationHandler {
    private final IAccountDAO accountDAO;
    
    public DynamicInvocationHandler(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
    	String arg = "";
    	if (args!=null)
    	for (Object object:args) {
    		if (object instanceof Account)
    		arg += "Account number:"+((Account) object).getAccountnumber();
    		if (object instanceof Long)
        	arg += "Account number:"+object;
    	}
    	long start = System.nanoTime();
        Object result = method.invoke(accountDAO, args);
        long elapsed = System.nanoTime() - start;
        Logger.getLogger("Account DAO").info(method.getName()+"{"+arg+"}"+" executed in "+elapsed+" ns");
        return result;
    }
}
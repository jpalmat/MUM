package sparkPackage;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class Functions {
	public static Function<String, User> PARSE_USER_LINE = new Function<String, User>() {
		private static final long serialVersionUID = 959487686373862849L;

		@Override
		public User call(String customerLine) throws Exception {
			return User.parseFromCustomerLine(customerLine);}};

	public static Function<User, Long> GET_USER_ELAPSEDTIME = new Function<User, Long>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Long call(User customer) throws Exception {
			return new Long(customer.getTimeElapsed());}};
			
	public static class LongComparator implements Comparator<Long>,
			Serializable {
		
		private static final long serialVersionUID = 3152398743080165674L;

		@Override
		public int compare(Long a, Long b) {
			if (a > b)
				return 1;
			if (a.equals(b))
				return 0;
			return -1;}}

	public static Comparator<Long> COMPARATOR = new LongComparator();

	public static Function<String, User> PARSE = new Function<String, User>() {

		
		private static final long serialVersionUID = 1L;

		@Override
		public User call(String customerLine) throws Exception {
			return User.parseFromCustomerLine(customerLine);
		}
	};

}

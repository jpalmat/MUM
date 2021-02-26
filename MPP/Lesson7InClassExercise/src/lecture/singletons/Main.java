package lecture.singletons;

//https://dzone.com/articles/java-singletons-using-enum
public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {	
		MySingletonLazy lazy = MySingletonLazy.getInstance();	
		MySingletonEnum myEnum = MySingletonEnum.INSTANCE;
		myEnum.setValue(7);
		System.out.println(myEnum.getValue());
	}

}

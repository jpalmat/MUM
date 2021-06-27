package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
		
		List<String> lista = new ArrayList<String>();
		
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		
		//use java8 foreach to copy all list elements into strList
//		list.forEach(name -> System.out.println("prueba "+ name));
		MyConsumer consumer = new MyConsumer();
		
//		list.forEach(consumer);
		
//		Consumer<String> con = new Consumer<String>() {
//			
//			@Override
//			public void accept(String t) {
//				strList.add(t);
//			}
//		};
		
		list.forEach(x -> strList.add(x));
		strList.forEach(t -> System.out.println(t));
		
//		Consumer<String> con1 = t -> System.out.println(t);
//		list.forEach(con1);
//		con1.accept("jimmy");
	}
}

class MyConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}
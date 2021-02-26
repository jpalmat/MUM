package exe6;

public class Main {

	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i=0; i<5; i++) {
			queue.add(i); 
		}
		
//		System.out.println(queue.remove());
//		System.out.println(queue.remove());
//		System.out.println(queue.remove());
//		System.out.println(queue.remove());
		
		for(int i=0; i < 10; i++) {
			ThreadClass thread = new ThreadClass(queue);
			Thread t = new Thread(thread);
			t.start();
		}
	}
}

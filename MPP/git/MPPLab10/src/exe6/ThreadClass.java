package exe6;

public class ThreadClass implements Runnable{
	
	private Queue queue;

	public ThreadClass(Queue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		
		System.out.println(this.queue.remove());
	}
}

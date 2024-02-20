package multithreading;

public class Demo1 {
public static void main(String[] args) {
	HouseWork h1=new HouseWork();
	Thread t1=new Thread(h1);
	t1.start();
}
}
class HouseWork implements Runnable{

	@Override
	public void run() {
		
		Thread door=new Thread(()->{
			try {
				cleanDoor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread floor=new Thread(()->cleanFloor());
		Thread kitchen=new Thread(()->cleankitchen());
		Thread terrace=new Thread(()->cleanterrace());
		door.start();
		floor.start();
		kitchen.start();
		terrace.start();
	}
	public void cleanDoor() throws InterruptedException {
		System.out.println("started Cleaning door");
		this.wait(2000);
		System.out.println("completed Cleaning door");
	}
	public void cleanFloor() {
		System.out.println("started Cleaning floor");
		System.out.println("completed Cleaning floor");
	}
	public void cleankitchen() {
		System.out.println("started Cleaning  kitchen");
		System.out.println("completed Cleaning kitchen");
	}
	public void cleanterrace() {
		System.out.println("started Cleaning terrace");
		System.out.println("completed Cleaning terrace");
	}
	
}

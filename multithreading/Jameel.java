package multithreading;

public class Jameel implements Runnable{
	String task;
	Jameel(String mask){
		task = mask;
	}
	public static void main(String[] args) {
		
		Jameel j1 = new Jameel("cutting ticket");
		Jameel j2 = new Jameel("showing seats");
		Thread t1 = new Thread(j1,"cutting thread");
		Thread t2 = new Thread(j2,"showing seat thread");
		t1.setPriority(7);
		t1.start();
		
		t2.start();
	}
	public void run()
	{
		for(int i=1;i<=5;i++) {
			System.out.println("task: "+ task + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

package multithreading;

public class Cpu {
public static void main(String[] args) {
	for(int i=1;i<=1000;i++) {
		NewThread n=new NewThread();
		n.start();
		
	}
}
}
class NewThread extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
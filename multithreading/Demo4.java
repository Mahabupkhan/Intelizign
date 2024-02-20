package multithreading;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo4 {
public static void main(String[] args) {
	IncThread inc=new IncThread();
	ShowThread show=new ShowThread();
	AddThread add=new AddThread();
	Thread incThread=new Thread(inc);
	Thread showThread=new Thread(show);
	Thread addThread=new Thread(add);
	incThread.start();
	showThread.start();
	addThread.start();
}
}
class Head{
	Scanner scan=new Scanner(System.in);
	static int number=0;
	static int sum=0;
}
class IncThread extends Head implements Runnable{
	@Override
	public void run() {
		inc();	
	}
	public   void   inc() {
		for(int i=1;i<=2000;i++) {
			number++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class ShowThread extends Head implements Runnable{

	@Override
	public void run() {
		showSum();
		
	}
	public void show() {
		int val=0;
		do {
		try{
			System.out.println("1.show\n2.DontShow");
			val=scan.nextInt();
			if(val==1) {
				System.out.println(number);
			}
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}while(val!=2);
	}
	public void show2() {
		while(true) {
			System.out.println(number);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void showSum() {
		int uc=0;
		do {
			System.out.println("1.Show sum\n2.exit");
			uc=scan.nextInt();
			if(uc==1) {
			System.out.println("Current value of number : "+number);
			System.out.println("Sum till now : "+sum);
			}
			else if(uc==2){
				System.out.println("Thank you!!!");
			}
			else {
				System.out.println("Wrong input");
			}
		}while(uc!=2);
	}
	
}
class AddThread extends Head implements Runnable{

	@Override
	public void run() {
		showAddenvalue();
		
	}
	public void showAddenvalue() {
	while(true) {
		try {
			sum+=number;
			Thread.sleep(1000);
			//System.out.println("Adding is progressing...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	
}
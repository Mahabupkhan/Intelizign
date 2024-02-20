package multithreading;

import java.util.Scanner;

public class Demo2 {
public static void main(String[] args) {
	  Int intThread = new Int();
      String1 stringThread = new String1();
      Float floatThread = new Float();

      // Start threads for each instance
      intThread.start();
      stringThread.start();
      floatThread.start();
}
}
class Int extends Thread {
	public void run() {
		met();
	}
	public void met() {
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Enter a int : ");
			int a=scan.nextInt();
			System.out.println(a);
		}
	}
}
class String1 extends Thread {
	public void run() {
		met();
	}
	public void met() {
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Enter a String : ");
			String a=scan.next();
			System.out.println(a);
		}
	}
}
class Float extends Thread {
	public void run() {
		met();
	}
	public void met() {
		try(Scanner scan=new Scanner(System.in)){
			System.out.println("Enter a float : ");
			float a=scan.nextInt();
			System.out.println(a);
		}
	}
}
package exceptionHandling;

import java.util.Scanner;

public class CreateCustomException2 {

	public static void main(String[] args) {
		System.out.println("Enter age : ");
		Scanner scan=new Scanner(System.in);
		byte age=(byte) scan.nextByte();
		try {
			CantBeNegative.checkNo(age, "Age can't be less than zero");
			if(age>=18) {
				System.out.println("You are eligible to vote");
			}
			else {
				System.out.println("Grow up kid...U have to wait for "+(18-age)+" more years");
			}
		} catch (CantBeNegative e) {
			e.printStackTrace();
			main(args);
		}
		
	}

}
class CantBeNegative extends Exception{
	private CantBeNegative(String message) {
		super(message);
	}
	public static void checkNo(int number,String message) throws CantBeNegative {
		if(number<0) {
			throw new CantBeNegative(message);
		}
	}
	public static void checkNo(double number,String message) throws CantBeNegative{
		if(number<0) {
			throw new CantBeNegative(message);
		}
	}
}

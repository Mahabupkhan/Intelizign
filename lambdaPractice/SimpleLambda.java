package lambdaPractice;

public class SimpleLambda {
	static Printable printable=(s)->{
		System.out.println(s);
	};
	static Printable printable2=(s)->{
		System.out.println("name : "+s);
	};
	public static void main(String[] args) {
		
		printable.print("Basheer");
	}

	
}
interface Printable{
	public void print(String s) ;
		
}
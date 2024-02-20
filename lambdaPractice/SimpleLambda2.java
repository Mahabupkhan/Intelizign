package lambdaPractice;

public class SimpleLambda2 {
public static void main(String[] args) {
	AddaBleOrPrintable add=(a,b)->{
		System.out.println("Addition is "+(a+b));
	};
	AddaBleOrPrintable print=(a,b)->{
		System.out.println("A is "+a+"\n"+"B is "+b);
	};
	add.AddOrPrint(3, 4);
	print.AddOrPrint(3, 4);
}
}
interface AddaBleOrPrintable{
	public void AddOrPrint(int a,int b);
}
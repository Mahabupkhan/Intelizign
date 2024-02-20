package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MapDemo {
	static Scanner scan=new Scanner(System.in);
	static List<Employee> employees=new ArrayList<Employee>();
public static void main(String[] args) {
	int uc=0;
	do {
		System.out.println("1.AddToList\n2.showWithEncryptedPassword\n3.Exit");
		uc=scan.nextInt();
		if(uc==1)addToList();
		else if(uc==2)showWithEncryptedPassword();
		else if(uc==3)System.out.println("Thanks");
		else {
			System.out.println("Wrong input");
		}
	}while(uc!=3);
}
static void addToList() {
	System.out.println("Enter name : ");
	String name=scan.next();
	System.out.println("Enter password : ");
	String pass=scan.next();
	employees.add(new Employee(name,pass));
}
static void showWithEncryptedPassword() {
	List<Employee> empEncrypted;
	empEncrypted=employees.stream().map(e->{e.password=Encryptor.encrypt(e.password); return e;}).collect(Collectors.toList());
	List<String> returned =(List<String>) empEncrypted.stream().map(e->e.toString()).collect(Collectors.toList());
	returned.stream().forEach(System.out::println);
	
}
}
class Encryptor{
	public static String encrypt(String s) {
		String encrypted="";
		for(int i=0;i<s.length();i++) {
			encrypted+=(char)(s.charAt(i)+1);
		}
		return encrypted;
	}
}
class Employee{
	String name;
	String password;
	Employee(String name,String pass){
		this.name=name;
		this.password=pass;
	}
	@Override
	public String toString() {
		return "Name : "+name+"\n"+"Password : "+password;
	}
}
package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterDemo1 {
	static ArrayList<Person> persons=new ArrayList<Person>();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
	
	int uc=0;
	do {
		System.out.println("1.AddToList\n2.ViewUnder18\n3.Exit");
		uc=scan.nextInt();
		if(uc==1)addToList();
		else if(uc==2)showPersonsUnder18();
		else if(uc==3)System.out.println("Thanks");
		else {
			System.out.println("Wrong input");
		}
	}while(uc!=3);
}
static void addToList() {
	
	System.out.println("Enter name : ");
	String name=scan.next();
	System.out.println("Enter age : ");
	int age=scan.nextInt();
	persons.add(new Person(name,age));
}
static void showPersonsUnder18() {
	List<Person> under18=new ArrayList<Person>();
	under18=persons.stream().filter(n->n.age<18).collect(Collectors.toList());
	under18.stream().forEach(n->System.out.println(n.name));
}
}
class Person{
	String name;
	int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
}
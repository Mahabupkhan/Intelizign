package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
public static void main(String[] args) {
	/*List<Integer> nums=Arrays.asList(2,5,1,0,6,9,0,10,100,67,45);
	nums.stream().sorted().forEach(System.out::println);*/
	List<Basheer> basheers=Arrays.asList(
			new Basheer("basheer",21),
			new Basheer("Basheer2",19),
			new Basheer("basheer3",1)
			);
	basheers.stream().sorted(Comparator.comparing(b->b.age)).forEach(System.out::println);;
}
}
class Basheer{
	String name;
	int age;
	Basheer(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Name : "+name+"\nAge : "+age;
	}
}
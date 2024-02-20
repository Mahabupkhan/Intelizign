package streams;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamSpeedTest {
	static ArrayList<Employee> emp=new ArrayList<Employee>();
	static {
		for(int i=0;i<1000000;i++) {
			emp.add(new Employee("jameel","21"));
		}
	}
	public static void main(String[] args) {
		forMet();
		streamMet();
	}
	static void forMet() {
		long start=System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			emp.get(i).name="Basheer";
			emp.get(i).password="34";
		}
		long stop=System.currentTimeMillis();
		System.out.println("Time Taken for for loop: "+(stop-start));
	}
	static void streamMet() {
		long start=System.currentTimeMillis();
		emp.stream().forEach(e->{e.name="Niyaz";e.password="45";});
		long stop=System.currentTimeMillis();
		System.out.println("Time Taken for stream: "+(stop-start));
	}
}

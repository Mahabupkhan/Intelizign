package streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapDemo {
public static void main(String[] args) {
	//List<Double> weight= Arrays.asList(66.5,62.3,64.9);
	List<String> names= Arrays.asList("Gousar Niyaz","Jameel","Basheer");
	List<String> names2= Arrays.asList("Gousar Niyaz","Jameel","Basheer");
	List<List<?>> combined=Arrays.asList(names2,names);
	combined.stream().flatMap(s->s.stream()).forEach(System.out::println);
	
}
}

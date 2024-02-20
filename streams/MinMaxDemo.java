package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxDemo {
public static void main(String[] args) {
	List<Integer> nums=Arrays.asList(1,2,3,4,5,0,67,78);
	Optional<Integer> min=nums.stream().min((val1,val2)->{
		return val1.compareTo(val2);
	});
	
	System.out.println(min.get());
	
	Optional<Integer> max=nums.stream().max((val1,val2)->{
		return val1.compareTo(val2);
	});
	
	System.out.println(max.get());
}
}

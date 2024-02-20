package streams;

import java.util.Arrays;
import java.util.List;

public class DistinctDemo {
public static void main(String[] args) {
	List<Integer> nums=Arrays.asList(1,2,3,4,4,5,78,5,0,67,78);
	nums=nums.stream().distinct().toList();
	System.out.println(nums);
}
}

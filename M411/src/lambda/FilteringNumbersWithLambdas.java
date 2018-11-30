package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import helper.Util;

public class FilteringNumbersWithLambdas {

	public static void main(String[] args) {
		ArrayList<Integer> aL = Util.fillrandArrayList(100000);
		List<Integer> range = aL.stream().filter((I)-> I>10 && I<20).collect(Collectors.toList());
		range.forEach((I)->System.out.println(I));
	}
	
	

}

package examples.miscexxamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Created by arpit on 2/2/17.
 */
public class ComparatorUsingLambda {

    public static void main(String[] args) {

		Integer a[]=new Integer[]{1,2,3};

		Arrays.sort(a,(Integer x,Integer y)-> y.compareTo(x));

		System.out.println(Arrays.toString(a));
	}

}



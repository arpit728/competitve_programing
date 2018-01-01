package misc;

import java.util.*;

/**
 * Created by arpit on 6/12/16.
 *
 * Problem link:- http://www.geeksforgeeks.org/sum-maximum-elements-subsets/
 */
public class SumOfMaximumElementOfAllSubset {

    public static void main(String[] args) {

        Integer a[]={3,3,3,3,2,2,5};

        System.out.println(solve(a,a.length));
    }

    private static int solve(Integer[] a, int n) {

        int sum;

        Comparator<Integer>cmp=new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        };

        TreeSet<Integer>set= new TreeSet<>(cmp);

        set.addAll(Arrays.asList(a));
        sum=set.pollFirst();

        Iterator<Integer>itr=set.iterator();

        while (itr.hasNext()){
            sum=sum*2+itr.next();
        }
        return sum;
    }
}

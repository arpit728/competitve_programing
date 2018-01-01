package misc;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;
import java.util.HashMap;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        int a[]=new int[100000];
        Arrays.fill(a, 10000);
        int solution1 = solution.solution(new int[]{1,0, 2, 0, 0,2});

        System.out.println(solution1);
    }


    public int solution(int[] A) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int a:A){
            if(hashMap.containsKey(a)){
                hashMap.put(a,hashMap.get(a)+1);
            }
            else{
                hashMap.put(a,1);
            }
        }

        int result = 0;

        for(Integer a : hashMap.values()){
            result = result + (a);
        }

        String s = Integer.toBinaryString(result);
        String s1 = s.replaceAll("0", "");

        return s1.length();

    }
}
package hiringchallenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpit on 26/5/17.
 */
public class AlphanumericCombinations {


    public static void main(String[] args) {

        System.out.println(calculatePossibleCombinations("2101"));
    }
    static long calculatePossibleCombinations(String input) {

       
        if (input.charAt(input.length()-1)=='0')return 0;
        int n=input.length();
        ArrayList<String>list=new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if ("0".equals(input.charAt(i + 1)+"")) {
                String temp=input.charAt(i)+""+input.charAt(i+1);
                if (Integer.parseInt(temp)>26)return 0;
                list.add(temp);
                i++;
            }
            else list.add(input.charAt(i)+"");
        }
        if (!"0".equals( input.charAt(n-1)+""))
            list.add(input.charAt(n-1)+"");

        System.out.println(list);
        n = list.size();
        int a[] = new int[n];
        int [] dp = new int [n+1];
        dp[0] = 0;

        for (int i = 0; i <n; i++) {
            a[i] = Integer.parseInt(list.get(i));
        }

        for(int i=1; i<=n; i++) {
            if(i>1 && a[i-2] <= 2 && a[i-1] <= 6) {
                dp[i] = dp[i-1] + dp[i-2] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n]+1;

    }
    /*static long calculatePossibleCombinations(String input) {

        List<String> combinationList = new ArrayList<>();
        List<String> temporaryList = new ArrayList<>();

        int cnt=0;
        for (int c = 0; c < input.length(); c ++){
            List<String> intermediate1 = new ArrayList<>();
            List<String> intermediate2 = new ArrayList<>();
            if (c >=  1){
                int val = Integer.valueOf(input.substring(c - 1, c + 1));
                if (val <= 26 && val >= 10){
                    char chr = (char)(val + 96);
                    intermediate1 = intermediateArray(temporaryList, chr);
                }
            }
            int val = Integer.valueOf(input.substring(c, c + 1));
            if (val != 0){
                char chr = (char)(val + 96);
                intermediate2  = intermediateArray(combinationList, chr);
            }
            temporaryList = combinationList;
            intermediate1.addAll(intermediate2);
            combinationList = intermediate1;
        }
        return combinationList.size();
    }

    private static List<String> intermediateArray(List<String> preRet, char chr) {

        List<String> ret = new ArrayList<>();
        if (preRet.size() == 0){
            ret.add(String.valueOf(chr));
        }
        for (String item : preRet){
            ret.add(item + String.valueOf(chr));
        }
        return ret;
    }*/

}

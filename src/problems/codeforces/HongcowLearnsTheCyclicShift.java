package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 20/12/16.
 */
public class HongcowLearnsTheCyclicShift {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder(br.readLine());
        System.out.println(solve(sb));
    }

    private static int solve(StringBuilder sb) {

        int count=1,length=sb.length();
        String initialString=sb.toString();
        StringBuilder shiftedString=sb.insert(0,sb.charAt(length-1));
        sb.deleteCharAt(initialString.length());

        while (!initialString.equals(shiftedString.toString())){
             shiftedString.insert(0,shiftedString.charAt(length-1));
            shiftedString.deleteCharAt(length);
            count++;
        }

        return count;
    }
}

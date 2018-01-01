package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Arpit on 26-Dec-15.
 */
public class LittleElephantAndCandies {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,c,t,sum;
        String s[];
        try {
            t= Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                s=br.readLine().split("\\s");
                n=Integer.parseInt(s[0]);
                c=Integer.parseInt(s[1]);
                sum=0;
                s=br.readLine().split("\\s");

                for (int j = 0; j < n; j++) {
                    sum=sum+Integer.parseInt(s[j]);
                }

                if (sum<=c) System.out.println("Yes");

                else System.out.println("No");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

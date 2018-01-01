package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Created by Arpit on 18-Dec-15.
 */
public class PetrContest {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),n,temp,teams;
        while (t-->0){
            n=sc.nextInt();
            teams=temp=0;
            temp=sc.nextInt();
            n--;
            while (n-->0){
                temp=sc.nextInt();
                if (temp==-1)teams++;
            }
            teams=teams/2+1;
            System.out.println(teams);
        }
    }
}

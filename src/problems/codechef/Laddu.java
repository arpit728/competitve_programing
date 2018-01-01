package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 5/16/2016.
 */

//problem link: https://www.codechef.com/MAY16/problems/LADDU
public class Laddu {

    static  BufferedReader br;
    static final String S_1="CONTEST_WON";
    static final String S_2="TOP_CONTRIBUTOR";
    static final String S_3="BUG_FOUND";
    static final String S_4="CONTEST_HOSTED";

    public static void main(String[] args) throws IOException {

        int t;
        String s[];
        br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        while (t-->0){
            s=br.readLine().split("\\s");
            System.out.println(solve(Integer.parseInt(s[0]),s[1]));
        }
    }

    private static int solve(int activities, String origin) throws IOException {
        String s[]=null;
        int sum=0;
        for (int i = 0; i < activities; i++) {
            s=br.readLine().split("\\s");
            switch (s[0]){
                case S_1:
                    sum+=300;
                    int rank=Integer.parseInt(s[1]);
                    if (rank<=20)sum+=20-rank;
                    break;
                case S_2:
                    sum+=300;break;
                case S_3:
                    sum+=Integer.parseInt(s[1]);
                    break;
                case S_4:
                    sum+=50;
                    break;
                default:break;
            }
        }

        //System.out.println(origin.equals("INDIAN"));
        return ((origin.equals("INDIAN"))?(sum/200):(sum/400));
    }
}

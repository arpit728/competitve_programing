package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 14/11/16.
 * PROBLEM LINK: https://www.codechef.com/problems/MAKEART
 */


public class Art {

    static final int MAX=100000;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){

            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,n));
        }
    }


    private static String solve(int[] a, int n) {

        for (int i = 1; i<(n-1); i++) {
            if (a[i]==a[i-1] && a[i]==a[i+1])return "Yes";
        }
        return "No";


        //It's possible to not allocate any array at all and just compute the answer on the fly, like in the following:

        /*int curr=xenny[1],prev=xenny[0],next=0;// replace the assignment by input

        for (int i =2; i < n; i++) {
            next=xenny[i];// replace the assignment by input
            if (curr==prev && curr==next)return "Yes";
            prev=curr;
            curr=next;
        }
        return "No";*/

    }
}

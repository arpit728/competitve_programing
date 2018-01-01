package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by arpit on 3/9/16.
 */
public class Chapter2 {

    static  int weight[];
    static boolean hash[];
    final static int MAX=100000;
    static int itr;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n,w;
        String s[];

        hash=new boolean[MAX];
        weight =new int[MAX];


        n=Integer.parseInt(br.readLine());
        w=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");
        itr=n;
        for (int i = 0; i < n; i++) {
            weight[i]=Integer.parseInt(s[i]);
        }

        //solve(n,w);
    }

    private static String solve(int n, int w) {

        boolean subset[][];

        StringBuilder sbr=new StringBuilder();

        int m=w;
        while (itr-->0){
            subset=calSubset(n,w);
            sbr.append(getSolution(subset,n,w));
        }
        return null;

    }

    private static String getSolution(boolean[][] subset, int n, int w) {

        int i,j,count=0;
        i=w;
        j=n;
        Stack<Integer>sol=new Stack<>();
        while (j>0 && i>0){

            if(hash[j]){

                if (subset[i][j]){
                    if (subset[i][j-1])j--;
                    else{
                        i=i-weight[j];
                        hash[j]=true;
                        sol.add(j);
                        count ++;
                    }
                }
                else{
                    i--;
                    j--;
                }
            }
            else j--;
        }
        itr-=count;
        return getString(sol).toString();
    }

    static boolean[][] calSubset(int n, int sum)
    {
        // The value of subset[i][j] will be true if there is a
        // subset of set[0..j-1] with sum equal to i
        boolean subset[][]=new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n && !hash[j]; j++)
            {
                subset[i][j] = subset[i][j-1];

                if (i >= weight[j-1])
                    subset[i][j] = subset[i][j] || subset[i - weight[j-1]][j-1];
            }
        }

        return subset;
    }

    private static StringBuilder getString(Stack<Integer> list) {

        StringBuilder sbr=new StringBuilder();

        while (!list.isEmpty()){
            sbr.append(list.pop());
            sbr.append(" ");
        }

        sbr.deleteCharAt(sbr.length()-1);
        sbr.append("\n");
        return sbr;
    }
}

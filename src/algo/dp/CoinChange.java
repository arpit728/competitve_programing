package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Arpit on 25-Dec-15.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,p,dp[][],coins[];
        n=sc.nextInt();
        p=sc.nextInt();
        coins=new int[n];
        dp=new int[n][p+1];

        for (int i = 0; i < n; i++) {
            coins[i]=sc.nextInt();
        }

        for (int i = 1; i <= p; i++) {
            if (i%coins[0]==0)dp[0][i]=i/coins[0];
        }
        int same,prev;
        System.out.println("hey");
        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= p; j++) {

                if (j >= coins[i]){
                    same=dp[i][j-coins[i]];
                    prev=dp[i-1][j];

                    if (same==0 && prev==0)dp[i][j]=0;

                    else if (j%coins[i]==0)dp[i][j]=j/coins[i];

                    else if (same==0||prev==0)dp[i][j]=(same!=0?same+1:prev);

                    else dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }

                else dp[i][j] = dp[i - 1][j];
                System.out.println("hey");
            }

        }

        System.out.println("Hey, I am out of the loop");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        ArrayList<Integer>dist=new ArrayList<>();

        for (int i=n-1,j=p;i>=0&&j>0;){

            if (i==0){
                j-=coins[0];
            }
            if (dp[i][j]==coins[i]){
                dist.add(coins[i]);
                j-=coins[i];
            }

            else if (dp[i][j]==dp[i-1][j])i--;

            else {
                j=j-coins[i];
                dist.add(coins[i]);
            }
        }
        System.out.println(dist);

    }

    static int min(int a,int b){
        return a<b?a:b;
    }
}

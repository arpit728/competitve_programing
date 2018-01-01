package problems.codechef;

import java.io.BufferedInputStream;

/**
 * Created by Arpit on 19-Dec-15.
 */
public class BumblingBinks {

    static  final int MAX=1000001;
    static int dp[]=new int[MAX];
    static {
        dp[1]=1;dp[2]=1;dp[3]=2;dp[4]=1;dp[5]=2;dp[6]=2;dp[7]=3;dp[8]=1;
        dp[9]=2;dp[10]=2;dp[11]=3;dp[12]=2;dp[13]=3;dp[14]=3;dp[15]=4;dp[16]=1;
    }

    public static void main(String[] args) {
        int n,m,temp=0,ans;
        String s[]=readInputDemo().split("\\s");
        m=Integer.parseInt(s[0]);
        n=Integer.parseInt(s[1]);
        if (n==1)temp=1;
        else if (n==2)temp=1;
        else {
            while(n>1){
                n>>=1;
                temp++;
            }
        }
        System.out.println(temp);
    }
    public static int calculate(int n){
        if (dp[n]!=0)return dp[n];
        else if ((n&(n-1))==0)return 1;
        else {
            if (n%2==0){
                dp[n]=calculate(n/2);
            }
            else {
                dp[n]=calculate(n/2)+1;
            }
        }
        return dp[n];
    }
    public static String readInputDemo(){
        BufferedInputStream b=new BufferedInputStream(System.in);
        StringBuilder s=new StringBuilder();
        long val=0;
        try {
            int c=b.read();
            while(c!='\n'){
                s.append((char)c);
                c=b.read();
            }
        } catch (Exception e) {
        }

        return s.toString();
    }
}

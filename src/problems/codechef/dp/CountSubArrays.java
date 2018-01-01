package problems.codechef.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/7/2016.
 */
public class CountSubArrays {

        static final int MAX=100001;

        public static void main(String[] args) throws IOException {

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            int dp[]=new int[MAX];
            int a[]=new int[MAX];
            while(t-->0){

                int n=Integer.parseInt(br.readLine());

                String s[]=br.readLine().split("\\s");

                Arrays.fill(dp,0,n,1);
                long ans=0,count=1;
                boolean flag=false;

                for (int i = 0; i < n; i++) {
                    a[i]=Integer.parseInt(s[i]);
                }
                //System.out.println(Arrays.toString(a));
                if (n==1)ans=1;
                else {

                    for (int i = 1; i < n; i++) {

                        if (a[i-1]<=a[i]){

                            count++;

                            if (i+1==n)ans+=count*(count+1)/2;


                        }

                        else {
                            //System.out.println("Inside else + "+count);

                            if (count==1)ans++;

                            else ans+=count*(count+1)/2;

                            if (i+1==n)ans++;

                            count=1;

                        }
                        /*The question can be solved using two approach using dp and using formula n*(n+1)/2 to see the
                          dp approach uncomment the section below.
                          In dp dp[i] represents the no. of sub arrays that end at index i
                          */
                       /* if (a[i-1]<=a[i])dp[i]=dp[i-1]+1;

                            else dp[i]=1;

                        ans+=dp[i];*/

                    }
                }

                //System.out.println(Arrays.toString(dp));
                System.out.println(ans);
            }

        }
}

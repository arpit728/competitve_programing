package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 2/11/16.
 */
public class BitwiseAnd {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),n,k;
        String s[];

        while (t-->0){

            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);

            System.out.println(solve(n,k));
        }

    }

    private static int solve(int n, int k) {
        int sum=0,maxSum=0;

        int a=k-1,b=0;// variables for O(1) solution
        if ((k&1)==1)return k-1;

        else{
            b=(k-1)|k;
            if (b<=n)return k-1;
            return k-2;
        }

        //The below approach gives the solution in O(n^2);
        /*for (int i =1; i < n; i++) {

            for (int j =i+1; j <=n; j++) {

                sum=i&j;

                if (sum<k)
                    maxSum=Integer.max(sum,maxSum);
            }
        }


        return maxSum;*/
    }
}

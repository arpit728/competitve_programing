package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 12/1/17.
 */
public class RecipeConstruction {

    final static int MAX=1000000;
    final static int MOD=10000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            String s=br.readLine();
            System.out.println(solve(s,s.length()));
        }
    }

    private static long solve(String s, int n) {

        long ans=1;
        int start=0,end=n-1;

        while (start<=end){

            if (s.charAt(start)!='?' && s.charAt(end)!='?' && s.charAt(start)!=s.charAt(end)){
               return 0;
            }
            else if (s.charAt(start)=='?' && s.charAt(end)=='?'){
                ans*=26;
            }

            if (ans>=MOD)ans%=MOD;
            start++;
            end--;
        }

        return ans;
    }
}

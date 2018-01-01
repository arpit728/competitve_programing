package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 11/1/17.
 */
public class NotATriangle {

    final static int MAX=2000;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;

        while (true){
            n=Integer.parseInt(br.readLine());
            if (n==0)break;
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }
    }



    private static int solve(int[] a, int n) {
        int ans=0;

        Arrays.sort(a,0,n);

        for (int third =n-1; third>1; third--) {

            int start=0,end=third-1;

            while (start<end){

                if (a[end]+a[start]<a[third]){
                    ans+=end-start;
                    start++;
                }

                else end--;
            }
        }

        return ans;
    }
}

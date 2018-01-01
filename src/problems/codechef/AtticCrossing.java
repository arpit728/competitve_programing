package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 4/1/17.
 */
public class AtticCrossing {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        char []a;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            a=br.readLine().toCharArray();
            System.out.println(solve(a,a.length));
        }
    }

    private static int solve(char[] a, int n) {

        int maxLength=0,days=0,j;
        for (int i = 0; i < n; i++) {

            if (a[i]=='#')continue;
            else {
                int temp=1;
                for (j =i+1; j <n ; j++) {
                    if (a[j]=='.')temp++;
                    else {
                        i=j-1;
                        break;
                    }
                }
                if (temp>maxLength){
                    maxLength=temp;
                    days++;
                }
                if (j==n)break;
            }
        }

        return days;
    }
}

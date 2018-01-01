package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 12/2/2016.
 */
public class TrainPartner {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;

        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());

            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int abs;
        abs=n%8;
        n=(n/8)*8;
        String ans=null;
        switch(abs){
            case 0:
                ans=(n-1)+"SL";
                break;
            case 1:
                ans=(n+4)+"LB";
                break;
            case 2:
                ans=(n+5)+"MB";
                break;
            case 3:
                ans=(n+6)+"UB";
                break;
            case 4:
                ans=(n+1)+"LB";
                break;
            case 5:
                ans=(n+2)+"MB";
                break;
            case 6:
                ans=(n+3)+"UB";
                break;
            case 7:
                ans=(n+8)+"SU";
                break;
        }
        return ans;
    }
}

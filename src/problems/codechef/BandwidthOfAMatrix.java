package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/5/2017.
 */
public class BandwidthOfAMatrix {

    static boolean[][]a=new boolean[500][500];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,zeros,ones;
        String []s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            zeros=ones=0;
            n=Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                s=br.readLine().split("\\s");
                for (int j = 0; j <n; j++) {

                    if (s[j].equals("1"))
                        a[i][j]=true;
                    else{
                        a[i][j]=false;
                        zeros++;
                    }
                }
            }
            System.out.println(solve(a,n,zeros,ones));
        }
    }

    private static int solve(boolean[][] a, int n,int zeros,int ones) {

        int available,required,zerosTemp;

        for (int bw = 0; bw < n; bw++) {
            required=0;
            available=0;
            zerosTemp=0;
            for (int i = 0; i < n - bw - 1; i++) {

                for (int j = bw + i + 1; j < n; j++) {
                    if (a[i][j]) {
                        required++;
                    }
                    else {
                        zerosTemp++;
                    }
                    if (a[j][i]) {
                        required++;
                    }
                    else {
                        zerosTemp++;
                    }
                }
            }
            if (bw==0){
                for (int i = 0; i < n; i++) {
                    if (!a[i][i]){
                        available++;
                    }
                }
            }
            else
                available = zeros - zerosTemp;
            if (required<=available)
                return bw;
        }
        return 0;
    }
}

/*
1
7
1111111
1111111
1111111
1111111
1111111
1111111
1111111

1
4
1111
1111
1111
1111
*/

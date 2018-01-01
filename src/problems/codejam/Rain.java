package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 7/10/2016.
 */
public class Rain {
    final static int MAX_R=50;
    final static int MAX_C=50;
    static int a[][]=new int[MAX_R][MAX_C];
    static int h[][]=new int[MAX_R][MAX_C];
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        int t=Integer.parseInt(br.readLine()),i=1;
        while (t-->0){
            s=br.readLine().split("\\s");
            r=Integer.parseInt(s[0]);
            c=Integer.parseInt(s[1]);
            for (int j = 0; j < r; j++) {
                s=br.readLine().split("\\s");
                for (int k = 0; k <c; k++) {
                    a[j][k]=Integer.parseInt(s[k]);
                }
                System.out.println(Arrays.toString(a[j]));
            }
            System.out.println("Case #"+i+": "+solve());
            i++;
        }
    }

    private static int solve() {

        int L,R,T,B,sum=0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                L=getL(a[i][j],i,j);
                R=getR(a[i][j],i,j);
                T=getT(a[i][j],i,j);
                B=getB(a[i][j],i,j);

                int height=Integer.min(Integer.min(Integer.min(L,R),T),B);
                sum+=height-a[i][j];
                System.out.println(L+" "+R+" "+" "+T+" "+B+"\nHeight = "+height);

            }
        }
        return sum;
    }

    private static int getL(int m,int i,int j) {

        int res=m;
        for (int k = j-1; k>=0; k--) {
            if (a[i][k]>res)res=a[i][k];
        }
        return res;
    }

    private static int getR(int m,int i,int j) {
        int res=m;

        for (int k =j+1; k <c ; k++) {
            if(a[i][k]>res)res=a[i][k];
        }
        return res;
    }

    private static int getT(int m,int i,int j) {
        int res=m;
        for (int k = i; k>=0; k--) {
            if (a[k][j]>res)res=a[k][j];

        }
        return res;
    }

    private static int getB(int m,int i,int j) {
        int res=m;
        for (int k =i ; k<r  ; k++) {
            if (a[k][j]>res)res=a[k][j];
        }
        return res;
    }

}

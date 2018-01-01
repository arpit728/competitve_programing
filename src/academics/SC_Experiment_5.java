package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 2/16/2017.
 */
public class SC_Experiment_5 {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        int p,m,n,x[][],y[][];
        float w[][];
        float alpha;
        String[]s;

        //input no. of samples, input and output
        s=br.readLine().split("\\s");
        p=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        n=Integer.parseInt(s[2]);
        w= new float[n][m];
        alpha=(float)1/p;
        x=new int[p][];
        y=new int[p][];

        //read input values xi
        for (int i = 0; i < p; i++) {
            x[i]=inputArray(m);
        }

        //read output values, yi
        for (int i = 0; i < p; i++) {
            y[i]=inputArray(n);
        }

        for (int k = 0; k < p; k++) {
            calculateWeightMatrix(w,x,y,m,n,k);
            updateWeightMatrix(w,m,n,alpha);
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(w[i]));
            }
            System.out.println();
        }
        System.out.println("memorization is completed");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(w[i]));
        }

    }

    public static int[] inputArray(int n) throws IOException {
        String s[]=br.readLine().split("\\s");
        int a[]=new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        return a;
    }

    private static void updateWeightMatrix(float[][] w, float m, int n, float alpha) {

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                w[i][j]+=alpha*w[i][j];
            }
        }
    }

    private static void calculateWeightMatrix(float[][] w, int[][] x, int[][] y,int m,int n, int k) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                w[i][j]=x[k][j]*y[k][i];
            }
        }
    }

}
/*
4 2 3
-1 -1
-1 1
1 -1
1 1
-1 -1 1
-1 1 -1
-1 1 -1
1 1 -1
*/

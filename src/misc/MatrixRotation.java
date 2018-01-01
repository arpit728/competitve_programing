package misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/13/2017.
 */
public class MatrixRotation {

    public static void main(String[] args) throws IOException {

        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new FileReader("input.txt"));
        int n=Integer.parseInt(br.readLine());
        int a[][]=new int[n][n];
        String[]s;
        for (int i = 0; i < n; i++) {
            s=br.readLine().split("\\s");
            for (int j = 0; j < n; j++) {
                a[i][j]=Integer.parseInt(s[j]);
            }
        }

        System.out.println(rotate(a,n));

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

    }

    private static boolean rotate(int[][] a, int n) {

        if (a.length!=a[0].length)return false;

        for (int layer = 0; layer < (n / 2); layer++) {


            //int first = layer;
            int last=n-layer-1;

            for (int i = 0; i <last-layer; i++) {

                /*
                int top=a[layer][layer+i];

                a[layer][layer+i] = a[last - i][layer];


                int right=a[layer+i][last];
                a[layer+i][last]=top;

                int bottom=a[last][last-i];
                a[last][last-i]=right;

                a[last-i][layer]=bottom;

                */


                int top=a[layer][layer+i];

                //left to top
                a[layer][layer+i]=a[last-i][layer];

                //bottom to left
                a[last-i][layer]=a[last][last-i];

                //right to bottom
                a[last][last - i]=a[layer+i][last];

                //top to right
                a[layer+i][last]=top;

            }
        }
        return true;
    }

}
/*

3
1 2 3
4 5 6
7 8 9

5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

*/


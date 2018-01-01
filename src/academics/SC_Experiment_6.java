package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/16/2017.
 */
public class SC_Experiment_6 {

    static BufferedReader br;
    public static void main(String[] args) throws IOException {

        br=new BufferedReader(new InputStreamReader(System.in));
        int x[][],xDash[][],weight[][],y[][];
        String[]s;

        //Input the xi..(input vector)
        System.out.println("ENTER A INPUT VECTOR : ");
        s=br.readLine().split("\\s");
        x=new int[1][s.length];
        for (int i = 0; i <s.length; i++) {
            x[0][i]=Integer.parseInt(s[i]);
        }
        xDash=transpose(x);
        weight=multiply(xDash,x);
        y=multiply(x,weight);

        System.out.println("\nWEIGHT MATRIX");
        printMatrix(weight);

        System.out.println("\nOUTPUT : ");
        printMatrix(y);
        System.out.println();

        activation(y);

        System.out.println("OUTPUT AFTER APPLYING ACTIVATION FUNCTION : ");
        printMatrix(y);
        System.out.println();

        if (retrieve(x,y))
            System.out.println("NETWORK HAS SUCCESSFULLY RECOGNIZED THE GIVEN INPUT PATTERN");
        else
            System.out.println("SORRY! NETWORK CANNOT RECOGNIZE THE GIVEN INPUT PATTERN");
    }

    private static boolean retrieve(int[][] x, int[][] y) {

        for (int i = 0; i < x[0].length; i++) {
            if (x[0][i]!=y[0][i])
                return false;
        }
        return true;
    }

    private static void activation(int[][] y) {
        for (int i = 0; i < y[0].length; i++) {
            y[0][i]=Integer.signum(y[0][i]);
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsInA = a.length;
        int columnsInA = a[0].length; // same as rows in B
        int columnsInB = b[0].length;
        int[][] c = new int[rowsInA][columnsInB];
        for (int i = 0; i < rowsInA; i++)
        {
            for (int j = 0; j < columnsInB; j++)
            {
                for (int k = 0; k < columnsInA; k++)
                {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int[][] transpose(int[][] x) {
        int a[][]=new int[x[0].length][x.length];
        for (int i = 0; i < x[0].length; i++) {
            a[i][0]=x[0][i];
        }
        return a;
    }

    static void printMatrix(int [][]a){
        int n=a.length;
        for (int i = 0; i <a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
// 1 1 -1 -1
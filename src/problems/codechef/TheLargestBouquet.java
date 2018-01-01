package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 29/10/16.
 */
public class TheLargestBouquet {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int data[][]=new int[3][3];
        String s[][]=new String[3][];
        int t;
        t=Integer.parseInt(br.readLine());
        while (t-->0){

            s[0]=br.readLine().split("\\s");
            s[1]=br.readLine().split("\\s");
            s[2]=br.readLine().split("\\s");

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    data[i][j] = Integer.parseInt(s[i][j]);

            System.out.println(solve(data));
        }
    }

    private static long solve(int[][] data) {

        long rowSum=0;
        long colSum=0;
        long prevSum=0;

        for (int i = 0; i < 3; i++) {

            rowSum=0;

            for (int j = 0; j < 3; j++) {
                rowSum+=data[i][j];
            }

            //System.out.println(" row "+(i+1)+" : "+rowSum);
            rowSum=Long.max(rowSum,prevSum);
            prevSum=rowSum;

        }

        prevSum=0;

        for (int i = 0; i < 3; i++) {
            colSum=0;

            for (int j = 0; j < 3; j++)
                colSum += data[ j][i];

            //System.out.println(" column "+(i+1)+" : "+colSum);
            colSum=Long.max(colSum,prevSum);
            prevSum=colSum;

        }

        //System.out.println(rowSum+" "+colSum);
        prevSum=Long.max(rowSum,colSum);

        if (prevSum%2==0)
            return Long.max(0,prevSum-1);

        return prevSum;
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * Created by hardCode on 2/25/2017.
 */
public class RowAndColumnOperations {

    static int rowCount[]=new int[314159];
    static int colCount[]=new int[314159];


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,q,rowMax=0,colMax=0;
        String s[];
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        q=Integer.parseInt(s[1]);
        for (int i = 0; i < q; i++) {
            s=br.readLine().split("\\s");

            if ("ColAdd".equals(s[0])){
                colCount[Integer.parseInt(s[1])-1]+=Integer.parseInt(s[2]);
            }
            else
                rowCount[Integer.parseInt(s[1])-1]+=Integer.parseInt(s[2]);
        }
        for (int i = 0; i < n; i++) {
            rowMax=max(rowMax,rowCount[i]);
            colMax=max(colMax,colCount[i]);
        }
        System.out.println(rowMax+colMax);

    }

}

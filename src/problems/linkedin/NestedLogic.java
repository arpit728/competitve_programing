package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 3/11/16.
 */
public class NestedLogic {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1[]=br.readLine().split("\\s");
        String s2[]=br.readLine().split("\\s");

        System.out.println(solve(s1,s2));
    }

    private static int solve(String[] s1, String[] s2) {

        int d1,d2,m1,m2,y1,y2;

        d1=Integer.parseInt(s1[0]);
        m1=Integer.parseInt(s1[1]);
        y1=Integer.parseInt(s1[2]);

        d2=Integer.parseInt(s2[0]);
        m2=Integer.parseInt(s2[1]);
        y2=Integer.parseInt(s2[2]);

        if (y1<y2)return 0;


        if (y1==y2){

            if (m1<m2)return 0;

            if (m1==m2){


                if (d1<=d2)return 0;

                return (d1-d2)*15;
            }

            return (m1-m2)*500;
        }

        return 10000;

    }
}

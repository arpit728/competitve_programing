package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 25/12/16.
 */
public class DivideTheCake {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());

            if (360%n==0) System.out.print('y' + " ");
            else System.out.print('n'+" ");
            if (n<=360)System.out.print('y'+" ");
            else System.out.print('n'+" ");
            if (n*(n+1)/2<=360)System.out.print('y');
            else System.out.print('n');
            System.out.println();
        }
    }
}

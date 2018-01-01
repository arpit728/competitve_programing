package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 25/12/16.
 */
public class MagicPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            br.readLine();//input of array elements can simply be discarded because o/p is based on size of input ratner than input elements.
            System.out.println(n*(n-1)/2);
        }
    }
}

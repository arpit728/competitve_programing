package apac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 28/8/16.
 */
public class SherlockAndParenthesis {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        long l,r,min;
        String s[];
        t=Integer.parseInt(br.readLine());

        for (int i = 1;  i<= t; i++) {

            s=br.readLine().split("\\s");

            l=Long.parseLong(s[0]);
            r=Long.parseLong(s[1]);

            min=Long.min(l,r);
            long ans=min*(min+1)/2;
            System.out.println("Case #"+i+": "+ans);
        }

    }
}

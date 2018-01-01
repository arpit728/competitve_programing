package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 1/26/2016.
 */
public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        float y;
        int x;
        String s[];
        s=br.readLine().split("\\s");
        x=Integer.parseInt(s[0]);
        y=Float.parseFloat(s[1]);


        if (x%5==0){
            float amt=x+0.5F;
            if (amt<y){

                System.out.printf("%.2f",(y-amt));
            }
            else System.out.printf("%.2f", y);
        }
        else System.out.printf("%.2f",y);
    }
}

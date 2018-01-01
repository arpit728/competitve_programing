package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by arpit on 6/2/17.
 */

public class SS_Experiment_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,a,x,y,t1,t2,k1,k2;
        String[]s;
        Random r=new Random();
        a=r.nextInt(100);
        n= (int) (Math.pow(a,2)+r.nextInt(100));
        System.out.println("a = "+a+" n = "+n);
        s=br.readLine().split("\\s");
        x=Integer.parseInt(s[0]);
        y=Integer.parseInt(s[1]);
        t1=moduloExponentiation(a,x,n);
        t2=moduloExponentiation(a,y,n);
        k1=moduloExponentiation(t2,x,n);
        k2=moduloExponentiation(t1,y,n);
        if (k1==k2)
            System.out.println("Hurrah!! You have got valid keys");
        else
            System.out.println("Sorry you can't use this keys");

    }

    public static int moduloExponentiation(int x,int y,int m){
        int ans=1;
        while (y>0){
            if (y%2==1)ans=(ans*x)%m;
            x=(x*x)%m;
            y>>=1;
        }

        return ans;
    }
}

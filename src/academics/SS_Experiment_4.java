package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 4/2/17.
 */
public class SS_Experiment_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int p,m,q,d,e,phi,c,n;
        String s=br.readLine(),s1[];
        m=Integer.parseInt(s);

        s1=br.readLine().split("\\s");
        p=Integer.parseInt(s1[0]);
        q= Integer.parseInt(s1[1]);
        e= Integer.parseInt(s1[2]);
        n=p*q;

        phi=(p-1)*(q-1);
        d=calculateD(phi,e);
        c=moduloExponentiation(m,d,n);

        m=moduloExponentiation(c,e,n);

        System.out.println("Cipher text = "+c+"\nPlain text = "+m);
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

    private static int calculateD(int phi, int e) {

        int d;
        for (int i =phi+1; true ; i+=phi) {
            if (i%e==0){
                d=i/e;
                return d;
            }
        }

    }
}

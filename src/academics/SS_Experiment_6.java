package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/13/2017.
 */
public class SS_Experiment_6 {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int d[]=new int[2],e[]=new int[2],n1,n2,p1,q1,p2,q2,phi1,phi2,m,c;
        String s[];
        s=br.readLine().split("\\s");

        //input message
        m=Integer.parseInt(s[0]);

        //input senders p,q and e
        s=br.readLine().split("\\s");
        p1=Integer.parseInt(s[0]);
        q1= Integer.parseInt(s[1]);
        e[0]= Integer.parseInt(s[2]);

        s=br.readLine().split("\\s");
        p2=Integer.parseInt(s[0]);
        q2= Integer.parseInt(s[1]);
        e[1]= Integer.parseInt(s[2]);
        n1=p1*q1;
        n2=p2*q2;
        phi1=(p1-1)*(q1-1);
        phi2=(p2-1)*(q2-1);
        //e[0],[1] senders and receivers public key respectively
        //d[0],d[1] senders and receivers private key
        d[0]=calculateD(phi2,e[0]);
        d[1]=calculateD(phi1,e[1]);

        //encrypt using receivers public key
        c=moduloExponentiation(m,e[1],n2);
        //sign using sender's private key
        c=moduloExponentiation(c,d[0],n1);

        System.out.println("Signed message = "+c);

        //decryption using sender's public key
        m=moduloExponentiation(c,e[0],n1);
        //decryption using receiver's private key
        m=moduloExponentiation(m,d[1],n2);

        System.out.println("Decrypted message = "+m);

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

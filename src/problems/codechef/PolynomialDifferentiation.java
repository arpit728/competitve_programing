package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 2/29/2016.
 */
public class PolynomialDifferentiation {

    public static void main(String[] args) throws IOException {
        int t,n;
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        while (t-->0){

            n= Integer.parseInt(br.readLine());
            Polynimial p[]=new Polynimial[n];

            for (int i = 0; i < n; i++) {

                s=br.readLine().split("\\s");
                p[i]=new Polynimial(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            }
            Arrays.sort(p);
            System.out.println(Arrays.toString(p));

            int i;
            for ( i = 0; i < n; i++) {
                if (p[i].exp!=0){

                    if (p[i].exp==1) System.out.print(p[i].coe);

                    else{
                        //System.out.println("xx");
                        System.out.print(p[i].exp * p[i].coe + "x^" + (p[i].exp - 1));

                    }
                    if (i<n-1 && p[i+1].exp!=0) System.out.print(" + ");

                }
            }
            System.out.println();
        }
    }
}

class Polynimial implements Comparable<Polynimial>{
    long exp,coe;

    public Polynimial(long coe, long exp) {
        this.exp = exp;
        this.coe = coe;
    }

    @Override
    public int compareTo(Polynimial o) {
        long a=this.exp;
        long b=o.exp;

        if (a<b)return 1;
        else if (a>b)return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Polynimial{" +
                "exp=" + exp +
                ", coe=" + coe +
                '}';
    }
}

package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/3/2017.
 */
public class RichieRich {

    static char a[]=new char[100000];
    static boolean change[]=new boolean[100000];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        a=br.readLine().toCharArray();
        int ans=solve(a,n,k);
        if (ans==-1)
            System.out.println(-1);
        else {
            for (char x:a)
                System.out.print(x);
            System.out.println();
        }
    }

    private static int solve(char[] a, int n, int k) {

        int start=0,end=n-1;
        while (start<end){
            if (a[start]!=a[end]){
                if (k==0)return -1;
                else {
                    if (a[start]>a[end]){
                        a[end]=a[start];
                        k--;
                        change[end]=true;
                    }
                    else {
                        a[start] = a[end];
                        k--;
                        change[start]=true;
                    }
                }
            }
            start++;
            end--;
        }
        start=0;
        end=n-1;

        while (start<end && k>0){

           if ((change[start]|| change[end]) && a[start]!='9'){
               k++;
               a[start]=a[end]='9';
               k-=2;
           }
            else if (a[start]!='9'&& (!change[start] && !change[end]) && k>=2){
                a[start]=a[end]='9';
                k-=2;
            }
            start++;
            end--;
        }
        if (n%2==1 && k>0 && a[n/2]!='9')
            a[n/2]='9';

        return 0;
    }
}

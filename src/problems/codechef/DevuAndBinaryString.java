package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/5/2017.
 * problem link :- https://www.codechef.com/MAY15/problems/DEVSTR
 */
public class DevuAndBinaryString {

    static char[]a=new char[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        String[]s;
        String s1;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            s1=br.readLine();

            for (int i = 0; i < n; i++) {
                if ("1".equals(s1.charAt(i)+""))
                    a[i] = '1';
                else
                    a[i]='0';
            }
            solve(a, n, k);
        }
    }

    private static void solve(char[] a, int n, int k) {

        if (k==1){
            int temp1=zeroStart(a,n);//Flips required to create an alternating sequence starting from 0
            int temp2=oneStart(a, n);//Flips required to create an alternating sequence starting from 1
            StringBuilder sbr=new StringBuilder();
            if (temp1<=temp2){
                System.out.println(temp1);
                for (int i = 0; i < n; i++) {

                    if ((i&1)==1){
                       sbr.append(1);
                    }
                    else {
                       sbr.append(0);
                    }
                }
                System.out.println(sbr.toString());

            }
            else {
                System.out.println(temp2);
                for (int i = 0; i < n; i++) {
                    if ((i&1)==1){
                        sbr.append(0);
                    }
                    else {
                        sbr.append(1);
                    }
                }
                System.out.println(sbr.toString());

            }
            return;
        }
        int sum=0,zeroCount=0,oneCount=0,start,end;

        if (a[0]=='0')zeroCount=1;
        else oneCount=1;

        if (a[n-1]=='1')a[n]='0';
        else a[n]='1';

        for (int i = 1; i <=n; i++) {

            if (a[i]=='1'){

                oneCount++;

                if (a[i]!=a[i-1]){
                    end=i-1;
                    start=end-zeroCount+1;
                    flipBits(a,start,end,k);
                    sum+=zeroCount/(k+1);

                    zeroCount=0;
                }
            }
            else {

                zeroCount++;
                if (a[i]!=a[i-1]){
                    end=i-1;
                    start=end-oneCount+1;
                    flipBits(a, start, end,k);
                    sum+=oneCount/(k+1);
                    //System.out.println("oneCount "+oneCount+" start "+start+" end "+end+" i "+i);
                    oneCount=0;
                }

            }
        }
        System.out.println(sum);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static int oneStart(char[] a, int n) {
        int flips=0;
        for (int i = 0; i < n; i++) {
            if ((i&1)==1){
                if (a[i]=='1')
                    flips++;
            }
            else {
                if (a[i]=='0')
                    flips++;
            }
        }
        return flips;
    }

    private static int zeroStart(char[] a, int n) {
        int flips=0;
        for (int i = 0; i < n; i++) {
            if ((i&1)==1){
                if (a[i]=='0')
                    flips++;
            }
            else {
                if (a[i]=='1')
                    flips++;
            }
        }
        return flips;
    }

    private static void flipBits(char[] a, int start, int end, int k) {
        if (start == end) {
            return;
        }
        int length = end - start + 1;
        boolean flag = false;
        if ((length % (k + 1)) == 0) {
            flag = true;
            flipBit(a, end);
        }
        for (int i = start + k; i <= end; i += k + 1) {
            flipBit(a, i);
        }
        if (flag)
            flipBit(a, end - 1);
    }
    private static void flipBit(char[]a,int i){
        if (a[i]=='1')
            a[i] = '0';
        else a[i]='1';
    }
}


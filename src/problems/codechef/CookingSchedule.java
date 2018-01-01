package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hardCode on 3/12/2017.
 */
public class CookingSchedule {

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
            System.out.println(solve1(a, n, k));
        }
    }

    private static int solve1(char[] a, int n, int k) {
        if (oneStart(a,n)<=k || zeroStart(a,n)<=k)
            return 1;

        return binarySearch(a,n,k);
    }

    private static int binarySearch(char[] a, int n, int k) {
        int start=2,end=n,mid,minLength=Integer.MAX_VALUE;

        while (start<=end){
            mid=(start+end)/2;
            boolean flag=isSegmentPossible(a,n,k,mid);
            if (flag)
            {
                minLength=Integer.min(minLength,mid);
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return minLength;
    }

    private static boolean isSegmentPossible(char[] a, int n, int maxFlips, int mid) {

        int oneCount,zeroCount,requiredFlips;
        oneCount=zeroCount=requiredFlips=0;

        if (a[n-1]=='0')
            a[n]='1';
        else a[n]='0';

        if (a[0]=='1')
            oneCount=1;
        else zeroCount=1;

        for (int i = 1; i <=n; i++) {
            if (a[i]=='1'){
                oneCount++;
                if (a[i]!=a[i-1]){
                    requiredFlips+=zeroCount/(mid+1);
                    zeroCount=0;
                }
            }
            else {
                zeroCount++;
                if (a[i]!=a[i-1]){
                    requiredFlips+=oneCount/(mid+1);
                    oneCount=0;
                }
            }
        }
        if (requiredFlips<=maxFlips)return true;

        return false;
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

    //Below code is the solution that takes exponential time

    private static int solve(char[] a, int n, int k) {

        return maximumBlockSize(a, n, k);
    }

    private static int maximumBlockSize(char[] a, int n, int k) {
        if (n==0 || k==0){
            return longestSegment(a);
        }
        char temp[]=new char[a.length];
        System.arraycopy(a,0,temp,0,a.length);
        if (a[n - 1] == '0') {
            temp[n-1]='1';
        }
        else {
            temp[n-1]='0';
        }
        int changed=maximumBlockSize(temp, n - 1, k - 1);
        int unchanged=maximumBlockSize(a, n - 1, k);
        return Integer.min(changed,unchanged);
    }

    static int longestSegment(char[]a){
        int maxZero=0,maxOne,zeros,ones;
        maxOne=zeros=ones=0;
        int n=a.length;
        for (int i = 0; i < n; i++) {
            if (a[i]=='0'){
                maxOne=Integer.max(maxOne,ones);
                ones=0;
                zeros++;
            }
            if (a[i]=='1'){
                maxZero=Integer.max(maxZero,zeros);
                zeros=0;
                ones++;
            }
        }
        maxOne=Integer.max(maxOne,ones);
        maxZero=Integer.max(maxZero,zeros);
        return Integer.max(maxOne,maxZero);
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Jarvis on 1/16/2017.
 */
class LRU {

    static int A[]=new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),s,n;
        String[]s1;
        while (t-->0){
            s1=br.readLine().split("\\s");
            n=Integer.parseInt(s1[0]);
            s=Integer.parseInt(s1[1]);
            s1=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                A[i]=Integer.parseInt(s1[i]);
            }
            lru(n,s,A,new int[s]);
        }
    }
    static void lru(int N, int S, int[] A, int cached_pages[]){
        boolean hash[]=new boolean[102];
        int cnt[]=new int[102];
        for (int i = 0; i < S && i<N; i++) {
            hash[A[i]]=true;
            cnt[A[i]]++;
        }
        if (N>S){
            for (int i = S; i < N; i++) {
                if (hash[A[i]])cnt[A[i]]++;
                else {
                    int x=getMinValue(cnt);
                    hash[x]=false;
                    hash[A[i]]=true;
                    cnt[A[i]]++;
                }
            }
            int k=0;
            for (int i = 0; i <= 100; i++) {
                if (hash[i]){
                    cached_pages[k]=i;
                    k++;
                }
            }

        }
        else {
            for (int i = 0; i < N; i++) {
                cached_pages[i]=A[i];
            }
        }
        Arrays.sort(cached_pages);
        for (int i = 0; i < S; i++) {
            System.out.print(cached_pages[i]+" ");
        }
        System.out.println();
    }

    private static int getMinValue(int[] cnt) {

        int x=10000;
        int min=0;
        for (int i = 0; i <101; i++) {
            if (cnt[i]>0){
                if (cnt[i]<x) {
                    min = i;
                    x=cnt[i];
                }
            }
        }
        return min;
    }


}

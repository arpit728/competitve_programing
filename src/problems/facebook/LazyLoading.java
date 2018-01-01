package facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 7/1/17.
 */
public class LazyLoading {

    static int a[]=new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t=Integer.parseInt(br.readLine());
        for (int i = 1; i <=t ; i++) {
            n=Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j]=Integer.parseInt(br.readLine());
            }
            System.out.println("Case #"+i+": "+solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {
        int trips=0,start=0,end=n-1;

        Arrays.sort(a,0,n);
       /* *//*for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }*//*
        System.out.println();*/
        while(start<end){
            if (a[end]>=50){
                trips++;
                end--;
                continue;
            }
            //System.out.println(a[end]+" "+end);
            int temp= (int) Math.ceil((double)50/a[end]);
            end--;
            int remain=end-start+1;
            if (remain>=(temp-1)){

                start+=temp-1;
                /*for (int i =1; i <temp ; i++) {
                    start++;
                }*/
            }
            else break;
            trips++;
        }

        return trips;
    }
}

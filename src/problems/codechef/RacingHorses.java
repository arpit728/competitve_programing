package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Arpit on 04-Jan-16.
 */
public class RacingHorses {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,arr[],ans;
        String s[];
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            arr=new int[n];
            ans=Integer.MAX_VALUE;
            for (int i = 0; i <n; i++) {
                arr[i]=Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            int temp=0;
            for (int i = 1; i < n; i++) {
                temp=Math.abs(arr[i]-arr[i-1]);
                if (temp<ans)ans=temp;
            }
            System.out.println(ans);
        }
    }
}

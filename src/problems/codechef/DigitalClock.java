package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/20/2016.
 */
public class DigitalClock {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),h,m;
        String s[];
        while (t-->0){
            s=br.readLine().split("\\s");
            h=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);

            int sum=min(min(10, h), m);
            h--;m--;
            sum+=min(h/11,m/11);

            for (int i =1,j=11; i<=min(9,h) && j<=m ; i++,j+=11)sum++;

            for (int i =11,j=1; i<=h && j<=m ; i+=11,j++)sum++;
            System.out.println(sum);
        }
    }
    static int min(int a, int b){
        return a<b?a:b;
    }
}

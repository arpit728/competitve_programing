package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 1/26/2016.
 */
public class ChefAndGifts {
    public static void main(String[] args) throws IOException {
        int t,n,k;
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        while(t-->0){
           s=br.readLine().split("\\s");
            int count=0,m;

            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            s=br.readLine().split("\\s");

            for (int i = 0; i <n; i++) {
                m=Integer.parseInt(s[i]);
                if (m%2==0) count++;
            }
            if ((k == 0) && (count == n)) System.out.println("NO");
            else if (count>=k) System.out.println("YES");
            else System.out.println("NO");
            
        }
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 23/4/17.
 */
public class BearAndCandies123 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,a,b;
        String s[],ans;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            int k=1;
            while (true){
                if ((k&1)==1){
                    a-=k;
                    if (a<0)
                    {
                        ans="Bob";
                        break;
                    }
                }
                else {
                    b-=k;
                    if (b<0)
                    {
                        ans="Limak";
                        break;
                    }
                }
                k++;
            }
            System.out.println(ans);
        }
    }
}

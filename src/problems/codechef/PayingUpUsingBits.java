package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 29-Dec-15.
 */
public class PayingUpUsingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,m,notes[];
        String s[];
        t=Integer.parseInt(br.readLine());

        while(t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            notes=new int[n];
            int itr= (int) Math.pow(2,n),sum,flag=0;

            for (int i = 0; i < n; i++) {
                notes[i]= Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <=itr ; i++) {

                sum=0;

                for (int j = 0; j <n; j++)
                    if ( (i & (1 << j)) > 0 ) sum += notes[j];

                if (sum==m){
                    flag=1;
                    break;
                }
            }
            if (flag==1) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

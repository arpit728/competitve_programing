package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 1/29/2016.
 */
public class GridChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int  t,n;
        t=Integer.parseInt(br.readLine());
        String s[];
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            char ch[][],p[];
            ch=new char[n][n];
            int count=0,count1=0;
            String ans="NO";
            s=new String[n];

            for (int i = 0; i < n; i++) {
                p=br.readLine().toCharArray();
                Arrays.sort(p);
                s[i]=new String(p);
            }
            Arrays.sort(s);
            for (int i = 0; i < n; i++) {
                count=0;
                for (int j = 0; j < n - 1; j++) {
                    if (s[j].charAt(i)<=s[j+1].charAt(i)) count++;
                    //System.out.println(s[j].charAt(i) + " " + s[j+1].charAt(i));
                }
                if (count==n-1)count1++;
                //System.out.println(s[i]+count+" "+count1);
            }
            if (count1==n)
            System.out.println("YES");
            else System.out.println("NO");
            /*for (int i = 0; i < n; i++) {
               ch[i]=br.readLine().toCharArray();
                Arrays.sort(ch[i]);
            }
            for (int i = 0; i < n; i++) {
                count=0;
                for (int j = 0; j < n-1; j++) {
                    if (ch[j][i]<=ch[j+1][i]){
                        count++;
                    }
                }
                if (count==n-1)ans="YES";
                else ans="NO";

                System.out.println(Arrays.toString(ch[i])+ans+count);
            }
            System.out.println(ans);*/

        }
    }
}

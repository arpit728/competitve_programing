package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/7/2016.
 */
public class SpecialDishes {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int d=Integer.parseInt(br.readLine());
        boolean hash[]=new boolean[127];
        while (d-->0){
            String s=br.readLine();
            String s1,s2;
            String ans;
            int l=s.length(),diff=0;
            Arrays.fill(hash,false);
            if (s.length()%2==0)
                if (s.substring(0, l / 2).equals(s.substring(l / 2, l)))
                    ans = "Yes";

            else {
                s1=s.substring(0,l/2+1);
                s2=s.substring(l/2+1,l);

                for (int i = 0; i < s2.length(); i++) {
                    if (s1.charAt(i)!=s2.charAt(i)){
                        hash[s1.charAt(i)]=true;
                        diff++;
                        if (diff>=3){
                            ans="No";
                            break;
                        }
                    }
                }
            }
            //System.out.println(ans);
        }
    }
}

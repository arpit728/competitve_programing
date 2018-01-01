package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/20/2016.
 */
public class ChefAndSpecialDishes {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        char s[];
        int l;
        while (t-->0){
            s=br.readLine().toCharArray();
            l=s.length;
            boolean flag=true;
            int cnt1=0,cnt2=0;
            if(l<=1)System.out.println("NO");

            else if (l%2==0){
                for (int i = 0,j=l/2 ; i <l/2 && j<l ; i++,j++) {
                    if (s[i]!=s[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag)System.out.println("Yes");
                else System.out.println("No");
            }
            else {
                for (int i = l/2,j=0 ; i <l && j<l/2 ; i++) {
                        if (s[i]==s[j]){
                            j++;
                            cnt1++;
                        }
                }

                for (int i = 0,j=l/2+1; i <=l/2 && j<l ; i++) {
                    if (s[i]==s[j]){
                        j++;
                        cnt2++;
                    }
                }
                if (cnt1==l/2||cnt2==l/2) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}

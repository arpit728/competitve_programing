package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 14/11/16.
 */
public class KGoodWords {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,k;
        String s[];
        char ch[];
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            ch=s[0].toCharArray();
            k=Integer.parseInt(s[1]);
            System.out.println(solve(ch,k));
        }
    }

    private static long solve(char[] ch, int k) {

        int freq[]=new int[26];
        int n=ch.length,m;
        long ans=Long.MAX_VALUE,count;

        for (int i = 0; i < n; i++) {
            freq[ch[i]-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            m=freq[i];
            if (m>0){

                count=0;
                for (int j = 0; j < 26; j++) {

                    if (freq[j]<m)count+=freq[j];

                    else if (freq[j]>(m+k))
                        count+=freq[j]-(m+k);
                }
                ans=Long.min(count,ans);
            }
        }

        return ans;
    }
}

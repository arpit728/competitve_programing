package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 9/1/17.
 *
 * problem link: https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/string-queries-1/description/
 */
public class StringQueries {

    static final int MAX=100000;
    static int prefix[][]=new int[26][MAX];
    static int f[]=new int[26];
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
         br=new BufferedReader(new InputStreamReader(System.in));
        char s[];
        int n,q;
        String input[];
        input=br.readLine().split("\\s");
        n=Integer.parseInt(input[0]);
        q=Integer.parseInt(input[1]);
        s=br.readLine().toCharArray();
        solve(s,n,q);
    }

    private static void solve(char[] s,int n, int q ) throws IOException {

        String input[];

        prefix[s[0]-'a'][0]=1;
        for (int i = 0; i < 26; i++) {

            for (int j = 1; j <n ; j++) {
                if (s[j]==(char)('a'+i)){
                    prefix[i][j]=prefix[i][j-1]+1;
                }
                else
                    prefix[i][j]=prefix[i][j-1];
            }
        }
       /* for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < q; i++) {
            input=br.readLine().split("\\s");
            int l=Integer.parseInt(input[0])-1;
            int r=Integer.parseInt(input[1])-1;
            System.out.println(calculateMinDeletion(l, r,prefix));
        }

    }

    private static int calculateMinDeletion(int l, int r, int[][] prefix) {


        for (int i = 0; i < 26; i++) {
            if (l==0)f[i]=prefix[i][r];
            else f[i]=prefix[i][r]-prefix[i][l-1];
        }
/*
        System.out.println(Arrays.toString(f));
*/

        int d=0,ans=Integer.MAX_VALUE,k;

        for (int i = 0; i < 26; i++) {
            d=0;k=f[i];
            for (int j = 0; j < 26; j++) {
                if (f[j]<k)d+=f[j];

                else d+=f[j]-k;
            }
            ans=Integer.min(ans,d);
        }
        return ans;
    }
}

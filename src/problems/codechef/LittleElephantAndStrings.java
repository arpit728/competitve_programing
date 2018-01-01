package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 10/1/17.
 */
public class LittleElephantAndStrings {

    static String favouriteLuckyStrings[]=new String[50];
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        int k,n;
        String s[]=br.readLine().split("\\s");
        k=Integer.parseInt(s[0]);
        n=Integer.parseInt(s[1]);
        for (int i = 0; i < k; i++) {
            favouriteLuckyStrings[i]=br.readLine();
        }
        solve(favouriteLuckyStrings,k,n);

    }

    private static void solve(String[] favouriteLuckyStrings, int k, int n) throws IOException {

        for (int i = 0; i < n; i++) {
            String s=br.readLine();
            boolean flag=false;
            if (s.length()<47)
            for (int j = 0; j < k; j++) {
                if (s.contains(favouriteLuckyStrings[j])){
                    System.out.println("Good");
                    flag=true;
                    break;
                }

            }
            else{
                System.out.println("Good");
                flag=true;
            }
            if (!flag) System.out.println("Bad");
        }
    }
}

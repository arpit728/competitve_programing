package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 3/9/16.
 */
public class ChapterFour {

    static int boys[];
    static int girls[];
    public static final int MAX=10001;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boys=new int[MAX];
        girls=new int[MAX];
        int t,m,n;
        String s1[];
        String s2[];
        String s[];
        t=Integer.parseInt(br.readLine());

        while (t-->0){

            s=br.readLine().split("\\s");
            m=Integer.parseInt(s[0]);
            n=Integer.parseInt(s[1]);

            s1=br.readLine().split("\\s");
            s2=br.readLine().split("\\s");

            for (int i = 0; i < m; i++) {
                boys[i]=Integer.parseInt(s1[i]);
            }

            for (int i = 0; i < n; i++) {
                girls[i]=Integer.parseInt(s2[i]);
            }

            System.out.println(solve(m,n));

        }

    }

    private static String solve(int m, int n) {

        if (n<m)return "NO";

        Arrays.sort(boys,0,m);
        Arrays.sort(girls,0,n);

        int count=0;

        for (int i = 0; i < m; i++) {

            if (count==m)break;

            if (girls[i]<boys[i]){
                count++;
                continue;
            }
        }

       if (count==m)return "YES";

        return "NO";
    }
}

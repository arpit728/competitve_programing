package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 14/12/16.
 */
public class ChefAndHisStudents {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        char[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().toCharArray();
            System.out.println(solve(s));
        }
    }

    private static int solve(char[] s) {
        int count=0;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i]=='<' && s[i+1]=='>')count++;
        }
        return count;
    }
}

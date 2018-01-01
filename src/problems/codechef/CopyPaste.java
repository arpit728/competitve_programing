package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by arpit on 25/12/16.
 */
public class CopyPaste {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        HashSet<Integer>set=new HashSet<>();
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(s[i]));
            }
            //Ans is no. of distinct elements in array.
            System.out.println(set.size());
            set.clear();
        }
    }
}

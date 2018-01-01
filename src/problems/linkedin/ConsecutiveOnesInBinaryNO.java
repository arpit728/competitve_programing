package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 2/11/16.
 */
public class ConsecutiveOnesInBinaryNO {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        n=Integer.parseInt(br.readLine());
        String s=Integer.toString(n,2);
        System.out.println(solve(s));
    }

    private static int solve(String s) {

        char ch[]=s.toCharArray();
        int count=0,pCount=0;

        if (ch[0]=='1'){
            count=1;
            pCount=1;
        }

        for (int i = 1; i <ch.length ; i++) {

            if (ch[i-1]=='0' && ch[i]=='1')count++;

            else if (ch[i-1]=='1' && ch[i]=='0'){
                pCount=Integer.max(count,pCount);
                count=0;
            }

            else count++;

            pCount=Integer.max(count,pCount);
        }
        return pCount;
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 29/12/16.
 */
public class PleaseLikeMe {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,l,d,s,c;
        String[]str;
        t=Integer.parseInt(br.readLine());

        while (t-->0){
            str=br.readLine().split("\\s");
            l=Integer.parseInt(str[0]);
            d=Integer.parseInt(str[1]);
            s=Integer.parseInt(str[2]);
            c=Integer.parseInt(str[3]);
            System.out.println(solve(l,d,s,c));

        }

    }

    private static String solve(int l, int d, int s, int c) {
        long ans=s;

        if (d==1){
            if (l<=ans)return "ALIVE AND KICKING";
            return "DEAD AND ROTTING";
        }

        for (int i = 1; i <d ; i++) {
            ans+=ans*c;
            if (ans>=l)return "ALIVE AND KICKING";
        }
        return "DEAD AND ROTTING";
    }
}

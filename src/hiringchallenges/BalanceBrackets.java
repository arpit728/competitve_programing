package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by arpit on 16/5/17.
 */

public class BalanceBrackets {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[]s;
        int n,cnt=0,pos=-1,temp=0;
        Stack<Character>stack=new Stack<>();
        s=br.readLine().toCharArray();
        br.readLine();
        if (s[0]==')' ||s[s.length-1]=='(')
        {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < s.length; i++)
        {

            if (s[i]=='(')
                cnt--;

            else cnt++;

            if (cnt>0)
                break;
            if (cnt==0)
                pos=i;

        }
        System.out.println(pos);
        if (pos!=-1){
            pos++;
            System.out.println(balancedPairCount(s, pos));
            return;
        }
        cnt=0;
        for (int i = s.length - 1; i >= 0; i--) {
            //System.out.println("hey");
            if (s[i]==')')
                cnt--;
            else cnt++;
            if (cnt>0)
                break;
            if (cnt == 0)
            {
                pos = i;
            }
        }
        System.out.println(pos);
        if (pos!=-1) {
            pos--;
            System.out.println(balancedPairCount(s, pos));
        }
    }

    private static int balancedPairCount(char[] s, int pos) {
        int temp;
        if (s[pos]=='('){
            temp=(s.length-pos+2)/2;
        }
        else {
            temp=(pos+2)/2;
        }
        return temp;
    }
}

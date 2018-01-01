package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/31/2017.
 */
public class BehindEnemyLines_Delloite {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        br.readLine();
        String w=br.readLine();
        String s=br.readLine();
        System.out.println(appearanceCount(w.length(),s.length(),w,s));
    }

    public static int appearanceCount(int input1,int input2,String input3,String input4)
    {
        int count=0;
        boolean hash[]=new boolean[126];

        for (int i = 0; i <input1 ; i++)
            hash[input3.charAt(i)] = true;

        for (int i = 0; i <=(input2-input1); i++) {
            boolean flag=true;
            for (int j = i; j < input1 + i; j++) {
                if (!hash[input4.charAt(j)]){
                    flag=false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

}
/*4
11
cAda
AbrAcadAbRa*/


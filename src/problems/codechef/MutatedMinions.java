package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Arpit on 17-Dec-15.
 */
public class MutatedMinions {
        public static void main(String[] args) {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try {
                int t= Integer.parseInt(br.readLine());
                String s[],tempValue[];
                int n,k;
                for (int i = 0; i < t; i++) {
                    int wolvarine=0,temp;
                    s=br.readLine().split("\\s");
                    n=Integer.parseInt(s[0]);
                    k=Integer.parseInt(s[1]);
                    //System.out.println(n+" "+k);
                    tempValue=br.readLine().split("\\s");
                    //System.out.println(Arrays.toString(tempValue));
                    for (int j = 0; j < n; j++) {
                        temp=Integer.parseInt(tempValue[j]);
                        temp=temp+k;
                        //System.out.println(temp);
                        if (temp%7==0)wolvarine++;
                    }
                    System.out.println(wolvarine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

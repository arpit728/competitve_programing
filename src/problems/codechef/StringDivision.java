package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 24/1/16.
 */
public class StringDivision {

    public static void main(String[] args) throws IOException {
        int t,len;
        String ans,s;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());

        while(t-->0){

            s=br.readLine();
            ans="NO";
            len=s.length();

            String s1,s2,s3,s4;

            if (len>=10) System.out.println("YES");

            else{
                outer:for (int i = 1; i<len ; i++) {
                    for (int j = i+1 ; j <len ; j++) {
                        for (int k = j+1; k < len; k++) {
                            s1=s.substring(0,i);
                            s2=s.substring(i,j);
                            s3=s.substring(j,k);
                            s4=s.substring(k,len);
                            System.out.println(s1+" "+s2+" "+s3+" "+s4);

                            if ((!s1.equals(s2)) && (!s1.equals(s3)) && (!s1.equals(s4)) && (!s2.equals(s3)) && (!s2.equals(s4)) && (!s3.equals(s4))) {
                                ans="YES";
                                System.out.println("arpit");
                                break outer;
                            }

                        }
                    }
                }
                System.out.println(ans);
            }
        }
    }
}

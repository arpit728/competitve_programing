package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InsertingEvenAndOdd {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=null;

        while (!(s=br.readLine()).isEmpty()){
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int l=s.length();
        StringBuilder sbr=new StringBuilder();
        sbr.append(s.charAt(0));
        for (int i = 1; i < l; i++) {

            int a=Integer.parseInt(s.charAt(i-1)+"");
            int b=Integer.parseInt(s.charAt(i)+"");

            if (a%2==1 && b%2==1){
                sbr.append("-");
            }

            else if (a%2==0 && b%2==0){
                sbr.append("*");
            }

            sbr.append(b);


        }
        return sbr.toString();
    }

}

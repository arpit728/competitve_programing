package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSuffix {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]s;
        String line=null;

        while (!(line=br.readLine()).isEmpty()){
            s=line.split(",");
            System.out.println(solve(s[0],s[1]));
        }
    }

    private static String solve(String s, String s1) {
        StringBuilder sbr=new StringBuilder();
        int n1=s.length(),n2=s1.length();
        for (int i=n1-1,j=n2-1; i>=0 && j>=0 ; i--,j--) {
            if (s.charAt(i)==s1.charAt(j))
                sbr.append(s.charAt(i));
            else break;
        }
        if (sbr.length()==0)return "NULL";
        return sbr.reverse().toString();
    }

}

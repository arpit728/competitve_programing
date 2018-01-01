package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by arpit on 25/12/16.
 */
public class TouristTranslations {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char hash[],str[];
        int t;
        String m,s[];
        s=br.readLine().split("\\s");
        t=Integer.parseInt(s[0]);
        hash=s[1].toLowerCase().toCharArray();

        StringBuilder sbr=new StringBuilder();
        for (int i = 0; i < t; i++) {
            str=br.readLine().toCharArray();
            for (int j = 0; j < str.length; j++) {
                if (str[j]=='_')sbr.append(" ");
                else if (str[j]>=97 && str[j]<=123)sbr.append(hash[str[j]-97]);
                else if (str[j]>=65 && str[j]<=90)sbr.append((char) (hash[str[j]-65]-32));
                else sbr.append(str[j]);
            }
            System.out.println(sbr);
            sbr.setLength(0);
        }
    }
}

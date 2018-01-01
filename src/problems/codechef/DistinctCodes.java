package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Arpit on 27-Dec-15.
 */
public class DistinctCodes {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char arr[];
        HashSet<String>hash;
        int t;
        t= Integer.parseInt(br.readLine());

        while (t-->0){
            arr=br.readLine().toCharArray();
            int len=arr.length,count=0;
            hash= new HashSet<>(len);
            for (int i = 0; i < len-1; i++)hash.add(""+arr[i] + arr[i + 1]);

            System.out.println(hash.size());

        }

    }
}

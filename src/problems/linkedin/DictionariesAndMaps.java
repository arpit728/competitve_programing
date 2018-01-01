package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by arpit on 3/11/16.
 */
public class DictionariesAndMaps {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {


        int n=Integer.parseInt(br.readLine());

        HashMap<String,Integer> map=new HashMap<>();
        String s[];

        while (n-->0){
            s=br.readLine().split("\\s");
            map.put(s[0],Integer.parseInt(s[1]));
        }

        solve(map);
    }

    private static void solve(HashMap<String, Integer> map) throws IOException {
        String s=br.readLine();

        Integer n;
        while (s.length()>0){

            n=map.get(s);

            if (n==null)
                System.out.println("Not found");

            else
                System.out.println(s+"="+n);

            s=br.readLine();
            //System.out.println("s="+s);
        }

    }
}

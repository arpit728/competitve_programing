package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Arpit on 10-Dec-15.
 */
public class ListingNames {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            int  t=Integer.parseInt(br.readLine());
            SortedMap<String,Integer> map=new TreeMap<String,Integer>();
            for (int i=0;i<t;i++){
                String s=br.readLine();
                if(!map.containsKey(s)){
                    map.put(s,1);
                }
                else {
                    Integer a=map.get(s);
                    a++;
                    map.put(s,a);
                }
            }
            Set s=map.keySet();
            Iterator itr=s.iterator();
            while (itr.hasNext()){
                String p= (String) itr.next();
                System.out.println(p+" "+map.get(p));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

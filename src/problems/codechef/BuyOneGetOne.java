package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Arpit on 04-Jan-16.
 */
public class BuyOneGetOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,ans;
        char ch[];
        HashMap<Character,Integer>map;
        ArrayList<Integer>temp;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            ch=br.readLine().toCharArray();
            map=new HashMap<>();
            int a=0;
            ans=0;
            for (int i = 0; i < ch.length; i++) {
                if (map.containsKey(ch[i])){
                    a=map.get(ch[i]);
                    a++;
                    map.put(ch[i],a);
                }
                else map.put(ch[i],1);
            }
            temp=new ArrayList<>(map.values());
            int size=temp.size();
            for (int i = 0; i < size; i++) {
                if (temp.get(i)%2==0)ans+=temp.get(i)/2;
                else ans+=temp.get(i)/2+1;
            }
            System.out.println(ans);
        }
    }
}

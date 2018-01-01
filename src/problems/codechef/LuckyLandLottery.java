package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by Arpit on 10-Dec-15.
 */
public class LuckyLandLottery {
    public static void main(String[] args) {
        int t,n,start;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            t=Integer.parseInt(br.readLine());
            while (t>0){
                String s[ ]=br.readLine().split("\\s");
                n=Integer.parseInt(s[0]);
                start=Integer.parseInt(s[1]);
                LinkedList<Integer> list=new LinkedList<Integer>();

                for (int i=1;i<=n;i++)list.add(i);

                int m=start,size=list.size();

                while (size>1){
                    if (m<size){
                        list.remove(m);
                        m++;
                        size--;
                    }
                    else m-=size;
                }
                System.out.println(list.get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

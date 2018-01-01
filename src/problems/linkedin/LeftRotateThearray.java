package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arpit on 3/11/16.
 */
public class LeftRotateThearray {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n,d;

        List<Integer>list=new LinkedList<>();
        String s[];
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        d=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }

        for (int i = d; i <n ; i++) {
            System.out.print(list.get(i) + " ");

        }

        for (int i = 0; i <d ; i++) {
            System.out.print(list.get(i) + " ");
        }

       /* list=solve(list, n, d);

        for (Integer x:list) System.out.print(x + " ");*/
    }

    private static List<Integer> solve(List<Integer> list, int n, int d) {
        List<Integer> list1;
        List<Integer> list2;

        if (d%n==0)return list;
        d%=n;

        list1=list.subList(0,d);
        list2= list.subList(d,n);
        list2.addAll(list1);

       return list2;
    }
}

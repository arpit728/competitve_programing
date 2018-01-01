package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by hardCode on 4/16/2016.
 */
public class RankTheFile {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i=0;

        Comparator<Integer>comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<=o2)return -1;
                else return 1;
            }
        };

        while (t-->0){

            TreeMap<Integer, int[]> map=new TreeMap<Integer, int[]>(comparator);
            int n= Integer.parseInt(br.readLine());
            int m=2*n-1;
            int a[]=new int[n],b[][]=new int[n][n];
            String s[];

            for (int j = 1; j <=m; j++) {
                s=br.readLine().split("\\s");
                for (int k = 0; k < n; k++) {
                   a[i]=Integer.parseInt(s[0]);
                }
                map.put(a[0],a);
                b[j-1]=a;
            }

        }
    }
}

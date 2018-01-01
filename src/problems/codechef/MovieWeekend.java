package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hardCode on 4/17/2016.
 */
public class MovieWeekend {

    public static void main(String[] args) throws IOException {
        int t,n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        String s1[],s2[];
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s1=br.readLine().split("\\s");
            s2=br.readLine().split("\\s");
            Data data[]=new Data[n+1];
            data[0]=new Data(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            for (int i = 1; i <= n; i++) {
                data[i]=new Data(i,Integer.parseInt(s1[i-1]),Integer.parseInt(s2[i-1]));
            }
            Arrays.sort(data, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.b>o2.b?-1:1;
                }
            });

            int big=data[0].a*data[0].b,ind=data[0].ind,temp;
            for (int i = 0; i < n; i++) {
                temp=data[i].a*data[i].b;
                if (temp>big){
                    big=temp;
                    ind=data[i].ind;
                }
            }
            System.out.println(ind);

        }
    }

    static class Data{
        int ind,a,b;

        public Data(int ind, int a, int b) {
            this.ind = ind;
            this.a = a;
            this.b = b;
        }
    }
}

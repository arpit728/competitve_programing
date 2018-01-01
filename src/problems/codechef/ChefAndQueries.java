package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Arpit on 20-Dec-15.
 */
public class ChefAndQueries {
    void solve(){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[]sp= new String[0];
        try {
            sp = br.readLine().split("\\s");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int q=Integer.parseInt(sp[0]);
        long s=Integer.parseInt(sp[1]);
        long a=Integer.parseInt(sp[2]);
        long b=Integer.parseInt(sp[3]);
        long sum=0;
        long set[]=new long[1<<25];

        for (int i = 1 ; i <=q ; i++) {

            int temp= (int) (s>>>1);
            long x=set[temp>>>6];
            long y=(1L<<(temp%64));

            if (temp!=0)
            if ((s&1)==1){

                if ((x&y)==0){
                    set[temp>>>6]^=y;
                    sum+=temp;
                }

            }

            else {
                if (((x&y)<0||((x&y)>0))){
                    set[temp>>>6]^=y;
                    sum-=temp;
                }
            }
            s = ((s*a+b)&((1L<<32)-1));
        }

        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        ChefAndQueries c=new ChefAndQueries();
        c.solve();

    }
}

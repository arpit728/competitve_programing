package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hardCode on 1/26/2016.
 */
public class ChefAndCakes {
    class Robot {
        int index;
        boolean cake;

        public Robot(int index) {
            this.index = index;
        }

        public boolean isCake() {
            return cake;
        }

        public void setCake(boolean cake) {
            this.cake = cake;
        }

        public void increaseIndex(int m){
            index+=m;
        }

        public void decreaseIndex(int m){
            index-=m;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "index=" + index +
                    ", cake=" + cake +
                    '}';
        }
    }

    public static void main(String[]args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,m;
        String s[];
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            new ChefAndCakes().solve(m,n);
        }
    }
    void solve(int m,int n){
        Robot[]r=new Robot[n+1];
        int k=1,p,count=0;

        for (int i = 1,j=m+1; i <=(n-m); i++,j++) {
            r[i]=new Robot(j);
        }

        for (int i =n-m+1,j=1; i <=n ; i++,j++) {
            r[i]=new Robot(j);
        }
        //System.out.println(Arrays.toString(r));


        do {
            r[k].setCake(true);
            k=r[k].getIndex();
            //System.out.print(k+" ");
            count++;

        }while (!r[k].isCake());

        if (count==n) System.out.println("YES");

        else System.out.println("NO "+count);

    }
}

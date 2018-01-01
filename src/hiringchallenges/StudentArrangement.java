package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 4/2/17.
 */
public class StudentArrangement {

    static final int MAX =100000;
    static int [] a =new int[MAX];
    static int[] count =new int[MAX];
    static int[]next=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m,k;
        String[]s;

        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        k=Integer.parseInt(s[2]);

        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i])-1;
        }
        System.out.println(solve1(a, n, m, k));
    }

    private static int solve1(int[] preference, int n, int m, int k) {
        int cnt=0;
        if (n>(m*k)){
            cnt=n-m*k;
            n=m*k;
        }
        initNext(m);

        for (int i = 0; i < n; i++) {
            if (count[preference[i]]<k)
                count[preference[i]]++;
            else if (count[next[preference[i]]]<k){
                count[next[preference[i]]]++;
                cnt++;
            }
            else {
                nextVacantRow(preference[i],k);
                count[next[preference[i]]]++;
                cnt++;
            }
        }
        return cnt;
    }

    private static int nextVacantRow(int i,int k) {
        int temp=next[i];
        if (count[temp]<k){
            next[i]=temp;
            return temp;
        }
        next[i]=nextVacantRow(next[i],k);
        return next[i];
    }

    private static void initNext(int m) {
        next[m-1]=0;
        for (int i = 0; i < m - 1; i++) {
            next[i]=i+1;
        }
    }

    private static int solve(int[] preference, int n, int m, int k) {
        int cnt=0;
        if (n>(m*k)){
            cnt=n-m*k;
            n=m*k;
        }

        for (int p = 0; p < n; p++) {

            if (count[preference[p]]<k){
                count[preference[p]]++;
            }
            else {
                int temp= nextEmptySit(preference[p] + 1, m, k);
                if (temp>=0)
                    count[temp]++;
                cnt++;
            }
            //System.out.println(ans);
        }
        return cnt;
    }

    private static int nextEmptySit(int row, int m, int k) {
        while (true){
            if (count[row%m]<k){
                return row%m;
            }
            row++;
        }
    }
}

package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hardCode on 7/1/2016.
 */
public class WeightedScheduling {

    final static int MAX=1000;

    static  int M[]=new int[MAX];
    static Job J[]=new Job[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        n= Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            s=br.readLine().split("\\s");
            J[i+1]=new Job(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));

        }

        Arrays.sort(J,1,n);

        //System.out.println(Arrays.toString(J));
        System.out.println(computeOptimalTD(n));
        System.out.println(computeOptimalBU(n));
        findSolution(n);
    }

    static int calculateLatestNonConflict(int i){

        for (int j = i-1; j>0 ; j--) {

            if (J[j].getFinishTime()<=J[i].getStartTime())
                return j;

        }

        return 0;
    }

    //This is bottom-up solution
    static int  computeOptimalBU(int j){
        int big=Integer.MIN_VALUE;
        for (int i = 1; i <= j; i++) {
            int pj=calculateLatestNonConflict(i);
            M[j]=Integer.max(M[j-1],M[pj]+J[i].getProfit());
            big=Integer.max(big,M[j]);
        }
        return big;
    }

    //This is the top down solution
    static int computeOptimalTD(int j){
        if (j==0)return 0;
        else if (M[j]>0)return M[j];
        else {
             int pj=calculateLatestNonConflict(j),vj=J[j].getProfit();

             M[j]=Integer.max(vj+ computeOptimalTD(pj),M[j-1]);
             return M[j];
         }
    }

    //This is to generate solution set
    static void findSolution(int n){
        int vj,pj;
        if (n==0)return;
        vj=J[n].getProfit();
        pj=calculateLatestNonConflict(n);
        if (vj+M[pj]>=M[n-1]){
            System.out.print(n+" ");
            findSolution(pj);
        }
        else {
            System.out.println(n-1+" ");
            findSolution(n-1);
        }

    }



}

class Job implements Comparable<Job>{

    private int startTime,finishTime,profit;

    public Job(int startTime, int finishTime, int profit){

        this.startTime = startTime;
        this.finishTime = finishTime;
        this.profit = profit;

    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public int compareTo(Job o) {
        Integer a=this.getFinishTime();
        Integer b=o.getFinishTime();
        return a.compareTo(b);
    }

    @Override
    public String toString() {
        return "Job{" +
                "startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", profit=" + profit +
                '}'+"\n";
    }
}

package apac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 28/8/16.
 */
public class WatsonAndIntervals {

    /*static long[] s;
    static long[] f;*/
    final static int MAX=500001;
    static Interval interval[]=new Interval[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        int n,l1,r1,a,b,c1,c2,m,t;
        t=Integer.parseInt(br.readLine());

        for (int i = 1; i <=t; i++) {

            s=br.readLine().split("\\s");

            n=Integer.parseInt(s[0]);
            l1=Integer.parseInt(s[1]);
            r1=Integer.parseInt(s[2]);
            a=Integer.parseInt(s[3]);
            b=Integer.parseInt(s[4]);
            c1=Integer.parseInt(s[5]);
            c2=Integer.parseInt(s[6]);
            m=Integer.parseInt(s[7]);

            System.out.println("Case #"+i+": "+solve(n,l1,r1,a,b,c1,c2,m));

        }
    }

    private static long solve(int n, int l1, int r1, int a, int b, int c1, int c2, int m) {

        if (n==1)return 0;
        long prevX,prevY,currX,currY;

        interval[0]=new Interval(l1,r1);
        prevX=l1;
        prevY=r1;


        for (int i = 1; i <n ; i++) {
            currX=(a*prevX+b*prevY+c1)%m;
            currY=(a*prevY+b*prevX+c2)%m;

            interval[i]=new Interval(Long.min(currX,currY),Long.max(currX,currY));

            prevX=currX;
            prevY=currY;

        }

        Arrays.sort(interval,0,n);
        return minimumCoveredArea(interval,n);
    }

    private static long minimumCoveredArea(Interval[] interval, int n) {
        long prevStart,prevEnd,minArea,currArea;

        prevStart=0;
        prevEnd=0;
        minArea=Integer.MAX_VALUE;
        currArea=0;

        for (int i = 0; i < n; i++) {
            if (i>0){
                prevStart=interval[0].start;
                prevEnd=interval[0].finish;
                currArea=interval[0].finish-interval[0].start+1;
            }
            for (int j = 1; j < n ; j++) {

                if (j==i)continue;

                if (interval[j].start>prevEnd){
                    currArea+=interval[j].finish-interval[j].start+1;
                    prevStart=interval[j].start;
                    prevEnd=interval[j].finish;
                }

                else if (interval[j].start>=prevStart && interval[j].finish<=prevEnd);

                else {
                    currArea+=interval[j].finish-prevEnd;
                    prevEnd=interval[j].finish;
                }
            }
            //System.out.println("curr"+currArea);
            minArea=Long.min(minArea,currArea);
        }
        return minArea;
    }

    static class Interval implements Comparable<Interval>{
        long start,finish;

        public Interval(long start, long finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Interval interval) {

            return ((Long)this.start).compareTo(interval.start);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }

}

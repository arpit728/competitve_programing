package hiringchallenges;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by hardCode on 2/23/2017.
 */
public class LargestSizeSet {


    public static void main(String[] args) {

        int a=0B1111;
        System.out.println(a);

    }

    static int solve(int []A){

        int size[]=new int[A.length];
        Arrays.fill(size,0,A.length,-1);

        for (int i = 0; i < A.length; i++) {
            size[i]=calSize(A,i,size,1);
            System.out.print(size[i] + " ");
        }
        System.out.println();
        int max=-1;
        for (int i = 0; i < A.length; i++) {
            max=Integer.max(max,size[i]);
        }
        return max;
    }

    private static int calSize(int[] a, int i,int[] size,int currSize) {

        if (a[i]==-1)return currSize-1;
        int temp=a[i];
        a[i]=-1;

        size[i]=calSize(a,temp,size,++currSize);
        return size[i];
    }


}

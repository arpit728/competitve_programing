package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 5/11/16.
 */
public class ArraySweetness {


    final static int MAX=101;
    static  int a[]=new int[MAX];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++)
            a[i]= Integer.parseInt(br.readLine());


        System.out.println(sweetness(a));


    }
    static int sweetness(int[] arr)
    {
        int n=arr.length,sweetness=0;
        data[]a=new data[n];

        for (int i = 0; i <n; i++) {
            a[i]=new data(arr[i],i);
        }

        Arrays.sort(a);


        for (int i = 0; i < n; i++) {

        }
        return sweetness;
    }

    static class data implements Comparable<data>{
        Integer d;
        int index;

        public data(int d, int index) {
            this.d = d;
            this.index = index;
        }

        @Override
        public int compareTo(data data) {

            return this.d.compareTo(data.d);
        }


    }
}

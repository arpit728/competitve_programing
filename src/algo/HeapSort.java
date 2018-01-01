package algo;

import java.util.Arrays;

/**
 * Created by hardCode on 4/16/2017.
 */
public class HeapSort {

     int a[];

    public HeapSort(int[] a) {
        this.a = a;
    }

    void buildMaxHeap(){

        for (int i =a.length/2; i>=0 ; i--)
            heapify(i, a.length);


        System.out.println(Arrays.toString(a));
    }

    private void heapify(int i, int n) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left<n && a[left]>a[largest])
            largest=left;

        if (right<n&&a[right]>a[largest])
            largest=right;

        if (largest!=i)
        {
            swap(i,largest);
            heapify(largest,n);
        }

    }

    public void sort(){
        buildMaxHeap();
        int n=a.length-1;
        for (int i = 0; i <=n; i++) {
            swap(0,n-i);
            heapify(0,a.length-i-1);
        }
    }

    private void swap(int i, int j) {
        int temp=a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[]=new int[]{11};
        HeapSort heap=new HeapSort(a);
        heap.sort();
        System.out.println(Arrays.toString(a));
    }
}

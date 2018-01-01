package misc;

import java.util.Arrays;

/**
 * Created by arpit on 5/12/16.
 *
 * Problem link:- http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 */
public class MaximumReapetingElement {

    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int k=8;

        System.out.println(findMaxElement(arr,arr.length,k));
    }

    //This function returns most repeating element in an array taking O(N)time and O(1) extra space.
    // This approach modifies the array original array can be obtained by setting every element to arr[i]=arr[i]%k.
    // Approach-4
    private static int findMaxElement(int[] arr, int n, int k) {

        for (int i = 0; i < n; i++) {
            arr[arr[i]%k]+=k;
        }

        //find biggest element in array
        int big=arr[0];
        for (int i = 1; i < n; i++) {
            big=Integer.max(big,arr[i]);
        }
        return big;
    }
    /**
     * Approach1:- simply one by one take all the elements and count its occurrences and
     * keep the track of maximum occurring element.
     * Time:-O(N^2)
     * Space:-O(1)
     *
     * Approach:-2
     * sort the array and count all elements and keep the track of maximum occurring element.
     * Time:-O(N)
     * space:-O(1)
     *
     * Approach:-3
     * Make an array if size k and initialize with zero, traverse the array and increase the value hash[arr[i]]
     * return the index with maximum value.
     * Time:-O(N)
     * Space:-O(K)
     *
     * Solution for approach 4 is given since it is the most optimum in terms of both time and space.
     *
    */
}

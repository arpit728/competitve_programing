package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 18/12/16.
 */
public class ChefAndSubset {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        t=Integer.parseInt(br.readLine());
        String[]s;
        while (t-->0){
            s=br.readLine().split("\\s");
            System.out.println(solve(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3])));
        }
    }

    private static String solve(int ...a) {
        if (checkSum1(a) || checksum2(a)||checkSum3(a) || checkSum4(a))return "Yes";
        else return "No";
    }

    private static boolean checkSum4(int[] a) {
        if (a[0]+a[1]+a[2]+a[3]==0)return true;
        return false;
    }


    private static boolean checkSum3(int[] a) {
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                for (int k =j+1; k < 4; k++) {
                    if (a[i]+a[j]+a[k]==0)return true;
                }
            }
        }
        return false;
    }

    private static boolean checksum2(int[] a) {
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j <4 ; j++) {
                if (a[i]+a[j]==0)return true;
            }
        }
        return false;
    }

    private static boolean checkSum1(int[] a) {
        for (int x:a){
            if (x==0)return true;
        }
        return false;
    }
}

package academics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/6/2017.
 */
public class SS_Experiment_10 {

    public static void main(String[] args) {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char pt[]="defend the east wall".toCharArray();
        int key=3;
        String cipherText=encrypt(pt,key);
        System.out.println(cipherText);

        System.out.println(encrypt1(pt, key));
    }

    //This function performs encryption using rail fence cipher without using extra space.
    private static String encrypt1(char[] pt, int key) {

        int diff=2*key-3;
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < key; i++) {

            for (int j = i; j < pt.length; j += diff + 1) {
                cipher.append(pt[j]);
            }
            diff-=2;
            if (diff==-1)
                diff=2*key-3;
        }
        return cipher.toString();
    }

    private static String encrypt(char[] pt, int key) {

        int k=0;
        boolean dir=true;
        char[][] cipher = new char[key][pt.length];
        for (int i = 0; i < pt.length; i++) {

            if (dir) {
                cipher[k][i]=pt[i];
                k++;
            }
            else {
                cipher[k][i]=pt[i];
                k--;
            }
            if (k==key){
                dir=false;
                k=key-2;
            }
            if (k==-1){
                k=1;
                dir=true;
            }
        }
        StringBuilder sbr=new StringBuilder();

        for (int i = 0; i < key; i++) {
            sbr.append(String.valueOf(cipher[i]));
        }
        return sbr.toString();
    }
}

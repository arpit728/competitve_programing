package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by hardCode on 4/12/2017.
 * problem link : http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 */
public class PossibleStringsThatCanBeMadeByPlacingSpaces {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        String s;
        t=Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s=br.readLine();
            printCombination(s,s.length());
            char str[]=s.toCharArray();
            char temp[]=new char[str.length*2];
            temp[0]=str[0];
            printCombination(str,temp,1,1,str.length);
        }
    }

    private static void printCombination(char[]str,char[]temp,int i,int j,int n){
        if (i==n){
            System.out.println(String.valueOf(temp));
            return;
        }
        
        temp[j]=str[i];
        printCombination(str,temp,i+1,j+1,n);
        
        temp[j]=' ';
        temp[j+1]=str[i];
        
        printCombination(str,temp,i+1,j+2,n);

    }

    private static void printCombination(String s, int n) {

        int max=1<<(n-1);
        ArrayList<String>list=new ArrayList<>();
        for (int i = 0; i <max ; i++) {
            StringBuilder sbr=new StringBuilder(s);
            int index=n-1;
            for (int j = 0; j <n-1 ; j++) {
                if (((1<<j)&i)>=1){
                    sbr.insert(index,' ');
                }
                index--;
            }
            list.add("("+sbr.toString()+")");
        }
        Collections.sort(list);
        list.forEach(System.out::print);
        System.out.println();
    }
}

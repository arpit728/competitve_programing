package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 10-Dec-15.
 */
public class CountCarryProblem {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            int t=Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String s[]=br.readLine().split("\\s");
                int n1=Integer.parseInt(s[0]),n2=Integer.parseInt(s[1]);
                int sum,carry=0,count=0,modn1=0,modn2=0;
                while (n1!=0 || n2!=0){
                    sum=modn1=modn2=0;
                    if (n1!=0){
                        modn1=n1%10;
                        n1/=10;
                    }
                    if (n2!=0){
                        modn2=n2%10;
                        n2/=10;
                    }
                    sum=modn1+modn2+carry;
                    carry=0;
                    if (sum>9){
                        carry=1;
                        count++;
                    }
                }
                if (count==0) System.out.println("No carry operation");
                else if (count==1)System.out.println(count+" carry operation");
                else System.out.println(count+" carry operations");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

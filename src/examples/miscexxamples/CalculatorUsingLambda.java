package examples.miscexxamples;

import java.util.Scanner;

/**
 * Created by arpit on 2/2/17.
 */
public class CalculatorUsingLambda {


    interface IntegerMath{
        int operation(int a,int b);
    }

    public static void main(String[] args) {

        IntegerMath a[]=new IntegerMath[3];

        a[0]=(x,y)-> x+y;
        a[1]=(x,y)->x-y;
        a[2]=(x,y)->x*y;

        Scanner sc=new Scanner(System.in);
        int op=sc.nextInt();
        System.out.print(a[op-1].operation(3,5));

    }

}

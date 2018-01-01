package misc;

/**
 * Created by arpit on 10/9/16.
 */
public class XorProduct {


    public static void main(String[] args) {
        System.out.println(new XorProduct().solution(9,12));
    }

    public int solution(int A, int B){

        //xorA calculates the xor up to A-1
        //xorB calculates the xor up to B

        int xorA=0,xorB=0;

        if ((A-1)%4==0)xorA=A-1;

        else if ((A-1)%4==1)xorA=1;
        else if ((A-1)%4==2)xorA=A;
        else if ((A-1)%4==3)xorA=0;

        if (B%4==0)xorB=B;
        else if (B%4==1)xorB=1;
        else if (B%4==2)xorB=B+1;
        else if (B%4==3)xorB=0;

        return xorA^xorB;

    }
}

package hiringchallenges;

/**
 * Created by bugkiller on 7/28/2017.
 */
public class FastFiboncci {

    public static void main(String[] args) {

        System.out.println(fib(8));
    }

    private static int fib(int n) {

        if (n==0 || n==1)
            return 1;

        int a[][] = new int[2][2];
        a[0][0]=1;
        a[0][1]=1;
        a[1][0]=1;
        a[1][1]=0;
        int[][] temp = power(a, n - 1);
        return temp[0][0] + temp[0][1];
    }

    private static int[][] power(int[][] a, int n) {

        if (n == 1) {
            return a;
        }

        else {
            int[][] temp = power(a, n / 2);

            temp = square(temp);
            if (n%2==1)
                temp=multiply(temp,a);

            return temp;
        }
    }

    private static int[][] square(int[][] a) {
        int temp[][] = new int[2][2];

        temp[0][0] = (a[0][0] * a[0][0]) + (a[1][0] * a[0][1]);
        temp[0][1] = (a[0][0] * a[0][1]) + (a[0][1] * a[1][1]);
        temp[1][0] = (a[1][0] * a[0][0]) + (a[1][1] * a[1][0]);
        temp[1][1] = (a[1][0] * a[0][1]) + (a[1][1] * a[1][1]);

        return temp;
    }

    static int[][] multiply(int temp[][], int a[][]) {

        int temp1[][] = new int[2][2];

        temp1[0][0] = (temp[0][0] * a[0][0]) + (temp[0][1] * a[1][0]);
        temp1[0][1] = (temp[0][0] * a[0][1]) + (temp[0][1] * a[1][1]);
        temp1[1][0] = (temp[1][0] * a[0][0]) + (temp[1][1] * a[1][0]);
        temp1[1][1] = (temp[1][0] * a[0][1]) + (temp[1][1] * a[1][1]);

        return temp1;

    }
}

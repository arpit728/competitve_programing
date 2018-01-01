package examples.miscexxamples;

import java.math.BigInteger;

/**
 * Created by hardCode on 4/15/2016.
 */
public class BigIntegerFactorial {

    public static void main(String[] args) {

        calculateFactorial(50);

    }
    public static void calculateFactorial(int n) {

        BigInteger result = BigInteger.ONE;

        for (int i=1; i<=n; i++) {

            result = result.multiply(BigInteger.valueOf(i));

        }

        System.out.println(n + "! = " + result);

    }
}

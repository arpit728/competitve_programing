package academics;

/**
 * Created by hardCode on 3/26/2017.
 */
public class SC_Experiment_7 {
    public static void main(String[] args) {
        double X[] = {1, -0.5, 3, -2};
        double D[] = {1, -1, 1, -1};
        double W[] = {-2.5, 1.75};
        double c[] = {1, .5, .1 };
        double bias= 1;


        double k = 1;
        double p = 1;
        double error = 0;

        double newW[] = W;
        double[] augumentedX ;

        int i = 0;

        boolean flag= true;
        while(flag){

            double[] oldW = newW;
            augumentedX = new double[]{ X[i] , bias};
            double result = product(augumentedX, newW);
            double signOfResult = sgn(result);
            newW = add( newW ,.5 , c[i%3], (D[i] - signOfResult) , augumentedX );
            flag = verify(oldW, newW);
            i = (i++)%X.length;
        }

        for (double v : newW) {
            System.out.println(v);
        }


    }

    private static boolean verify(double[] oldWeight, double[] newWeight) {
        boolean res = true;

        for (int i = 0; i < oldWeight.length; i++) {
            double o= oldWeight[i];
            double n= newWeight[i];
            if(o!=n) return false;
        }

        return res;
    }

    private static double[] add(double[] newW, double v, double c, double v1, double[] augumentedX) {

        double[] result = new double[2];

        for (int i = 0; i < newW.length; i++) {
            double a = augumentedX[i];
            double n = newW[i];
            result[i] = n+ (v * c * v1 * a);
        }

        return result;
    }

    private static double sgn(double result) {
        return (result>=0)?1:-1;
    }

    private static double product(double[] input, double[] weight) {

        double result = 0;

        for (int i = 0; i < input.length; i++) {
            result += input[i] * weight[i];
        }


        return result;
    }

}

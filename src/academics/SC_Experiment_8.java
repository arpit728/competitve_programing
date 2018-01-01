package academics;

import java.util.Arrays;

/**
 * Created by hardCode on 3/9/2017.
 */
public class SC_Experiment_8 {

    public static void main(String[] args) {

        double alpha=0.3;
        double[]x=new double[]{0.6,0.8,0};
        double[][]v=new double[][]{{2,1,0},{1,2,3},{0,2,1}};
        double []v0=new double[]{0,0,-1};
        double w[]=new double[]{-1,1,2};
        double t=0.9;
        double w0[]=new double[]{-1};
        double delta=Double.MAX_VALUE;
        while (delta>0.0005){
            delta=epoch(x,v,v0,w,w0,t,alpha);
        }

        System.out.println("Final weights for layer 1 : \n");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(v[i]));
        }


        System.out.println("\nFinal weights of layer 2 :\n ");
        System.out.println(Arrays.toString(w));

    }

    private static double epoch(double[] x, double[][] v, double[] v0, double[] w, double[] w0, double t, double alpha) {
        double deltaHidden[]=new double[3];
        double delataInputLayer[]=new double[3];
        double[]z=calculateZvalues(x,v,v0);
        double y=calculateY(z,w,w0);
        double fDash=y*(1-y);
        double delta=(t-y)*fDash;
        double changedWeights[][];
        errorLayer1(deltaHidden,w,delta);

        //calculate error in input layer
        System.arraycopy(z,0,delataInputLayer,0,3);//initialize delta input layer with z values in order to ease the calculation of F`
        for (int i = 0; i < 3; i++) {
            delataInputLayer[i]*=1-delataInputLayer[i];
            delataInputLayer[i]*=deltaHidden[i];
        }
        updateWeights(delataInputLayer, x, alpha, v);
        updateBias(delataInputLayer,alpha,v0);
        updateWeightsLayer2(w,deltaHidden,z,alpha);
        w0[0]+=alpha*delta;
        return delta;
    }

    private static void updateWeightsLayer2(double[] w, double[] deltaHidden, double[] z, double alpha) {
        for (int i = 0; i < 3; i++) {
            double temp=alpha*deltaHidden[i]*z[i];
            w[i]+=temp;
        }
    }

    private static void updateBias(double[] delataInputLayer, double alpha, double[] v0) {
        for (int i = 0; i < 3; i++) {
            double temp=alpha*v0[i];
            v0[i]+=temp;
        }
    }

    private static void updateWeights(double[] delataInputLayer, double[] x, double alpha, double[][] v) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double temp=x[j]*delataInputLayer[j]*alpha;
                v[i][j]+=temp;
            }
        }
    }

    private static void errorLayer1(double[] deltaLayer1, double[] w,double delta) {

        for (int i = 0; i < 3; i++) {
            deltaLayer1[i]=w[i]*delta;
        }
    }

    private static double calculateY(double[] z, double[] w, double[] w0) {

        double y=z[0]*w[0]+z[1]*w[1]+z[2]*w[2]+w0[0];

        return activation(y);
    }

    private static double[] calculateZvalues(double[] x, double[][] v, double[] v0) {
        double z[] = new double[3];
        for (int i = 0,j=0; i < 3; i++,j++) {
            z[i]=v[i][0]*x[0]+v[i][1]*x[1]+v[i][2]*x[2]+v0[i];
            z[i]=activation(z[i]);
        }
        return z;
    }

    private static double activation(double v) {

        return 1/(Math.exp(v)+1);
    }
}

package academics;

import java.util.*;

/**
 * Created by arpit on 25/1/17.
 */
public class SC_Experiment_2 {

    public static void main(String[] args) {

        int a[]=randBinaryArray(8);//Q.1
        int decOfA=binaryArrayToDecimal(a);//Q2
        int b[][]=randBinaryMatrix(10,8);//Q.3
        int decOfRandMatrix[]=binaryMatrixToDecimalArray(b);//Q.4

        int c[][]= rankBasedSelection(b, decOfRandMatrix);//Q.5

        //print the new mating pool
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }

        int d[][]=singlePointCrossOver(c,4);//Q.6 single point cross over mutation

        int e[][]=swappeditMutation(c, 2, 5);//Q.7 swapped bit mutation

        int f[],maxValue,temp,quadraticA;
        int k[]=randBinaryArray(8);//will be used for uniform cross over
        int twoPoint[][],uniform[][];

        quadraticA=quadraticEquation(decOfA);
        maxValue=quadraticA;

        f=binaryMatrixToDecimalArray(b);
        System.out.println(Arrays.toString(toQuadraticEquationValue(f)));
        temp=getMaximumValueFromArray(f);
        maxValue=Integer.max(temp, maxValue);

        f=binaryMatrixToDecimalArray(c);
        System.out.println(Arrays.toString(toQuadraticEquationValue(f)));
        temp=getMaximumValueFromArray(f);
        maxValue=Integer.max(temp,maxValue);

        f=binaryMatrixToDecimalArray(d);
        System.out.println(Arrays.toString(toQuadraticEquationValue(f)));
        temp=getMaximumValueFromArray(f);
        maxValue=Integer.max(temp,maxValue);

        f=binaryMatrixToDecimalArray(e);
        System.out.println(Arrays.toString(toQuadraticEquationValue(f)));
        temp=getMaximumValueFromArray(f);
        maxValue=Integer.max(temp,maxValue);

        System.out.println(maxValue);
        twoPoint=twoPointCrossOver(b,2,5);
        uniform=uniformCrossOver(b, k);

        System.out.println(ga(b, decOfRandMatrix));

    }

    private static double ga(int[][] b,int dec[]) {

        Random rand=new Random();
        int a[][]=copyOf(b),temp[][];
        double temp1[];
        temp=a;
        double ans=Double.MAX_VALUE;
        double prev1=Double.MAX_VALUE,prev2;

        for (int i = 0; i < 1000; i++) {
            temp= rankBasedSelection2(temp, dec);
            int p2=rand.nextInt(9)+1;
            int p1=rand.nextInt(p2);
            twoPointCrossOverBetweenTwoRows(temp,p1,p2);
            temp1=binaryMatrixToDecimalArrayFraction(temp);

            for (int j = 0; j < temp1.length; j++) {
                prev2=quadraticEquation(temp1[j]);
                if (prev2<prev1){
                    prev1=prev2;
                    ans=temp1[j];
                }
            }
        }

        return ans;
    }

    private static double[] binaryMatrixToDecimalArrayFraction(int[][] temp) {

        double a[]=new double[temp.length];
        for (int i = 0; i < 10; i++) {
            a[i]=binaryArrayToDecimalFraction(temp[i]);
        }
        return a;
    }

    private static double binaryArrayToDecimalFraction(int []n) {

        double ans1=0,ans2=0;
        double bitLength1=2,bitLength2=6;
        for (int j = 0; j < 2; j++) {
            if (j<3){
                ans1+=Math.pow(2,bitLength1--);
            }
            else {
                ans2+=Math.pow(2,bitLength2--);
            }
        }
        ans2/=100;
        ans1+=ans2;

        return ans1;
    }

    static void swap(int []a,int i,int j){

        int temp=a[2];
        a[2]=a[5];
        a[5]=temp;

    }
    private static int[][] uniformCrossOver(int[][] b, int[] k) {
        int a[][]=copyOf(b);

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (k[j]!=0){
                    int temp=a[i][j];
                    a[i][j]=a[i+1][j];
                    a[i+1][j]=temp;
                }
            }
        }

        return a;
    }

    private static int[][] twoPointCrossOver(int[][] b,int p1,int p2) {
        int [][]a=copyOf(b);
        Random rand=new Random();
        p2=rand.nextInt(7)+1;
        p1=rand.nextInt(p2);
        for (int i = 0; i < b.length-1; i+=2) {

            for (int j = p1; j <=p2 ; j++) {

                int temp=a[i][j];
                a[i][j]=a[i+1][j];
                a[i+1][j]=temp;
            }
        }

        return a;
    }

    private static void twoPointCrossOverBetweenTwoRows(int[][] a,int p1,int p2) {
        Random rand=new Random();
        int y=rand.nextInt(7)+1;
        int x=rand.nextInt(y);

        for (int j = x; j <=y ; j++) {
            int temp=a[p1][j];
            a[p1][j]=a[p2][j];
            a[p2][j]=temp;

        }

    }



    private static int getMaximumValueFromArray(int a[]){

        int ans=0;
        for (int i = 0; i < a.length; i++) {
            ans=Integer.max(ans,a[i]);
        }
        return ans;
    }

    private static int[] toQuadraticEquationValue(int[] f) {
        for (int i = 0; i < f.length; i++) {
            f[i]=quadraticEquation(f[i]);
        }
        return f;
    }



    //10X^2 - 5x + 8
    private static int quadraticEquation(int x){
        return 10*x*x-5*x+8;
    }

    private static double quadraticEquation(double x){
        return 10*x*x-5*x+8;
    }

    private static int[][] swappeditMutation(int[][] matingPool, int p1, int p2) {

        int n=matingPool.length;
        int x[][]=copyOf(matingPool);
        for (int i = 0; i <n ; n++) {
            int temp=x[i][p1];
            x[i][p1]=x[i][p2];
            x[i][p2]=temp;
        }
        return x;
    }

    private static int[][] singlePointCrossOver(int[][] matingPool, int crossoverPoint) {

        int row=matingPool.length;
        int col=matingPool[0].length;
        int mutatedPopulation[][]=copyOf(matingPool);

        for (int i = 0; i < row-1; i+=2) {
            for (int j = crossoverPoint; j < col; j++) {
                int temp=mutatedPopulation[i][j];
                mutatedPopulation[i][j]=mutatedPopulation[i+1][j];
                mutatedPopulation[i+1][j]=temp;
            }
        }
        return mutatedPopulation;
    }

    private static int[][]copyOf(int [][]a){
        int n=a.length;
        int m=a[0].length;
        int x[][]=new int[n][];
        for (int i = 0; i <n; i++) {
            x[i]=Arrays.copyOf(a[i],m);
        }
        return x;
    }

    //This functino considers rank as decimalvalues/avg
    private static int[][] rankBasedSelection(int[][] randMatrix, int[] decOfRandMatrix) {
        int n=decOfRandMatrix.length;
        int m=randMatrix[0].length;
        double avg=avg(decOfRandMatrix);
        double []rank=new double[n];
        int poolSize=0;
        int newMatingPool[][]=new int[n][];
        TreeMap<Double,Integer>map=new TreeMap<>();
        for (int i = 0; i < n; i++) {
            rank[i]=decOfRandMatrix[i]/avg;
            map.put(rank[i],i);
        }
        Set<Double> rankSet=map.keySet();

        Iterator<Double>itr=rankSet.iterator();
        while (itr.hasNext()){
            double temp=itr.next();
            if (Math.round(temp)>0){
                int tempRound= (int) Math.round(temp);
                int val=map.get(temp);
                for (int i = 0; i < tempRound && poolSize<n; i++) {
                    newMatingPool[poolSize++]=randMatrix[val];
                }
            }
            else {
                int tempRound= (int) Math.ceil(temp);
                int val=map.get(temp);
                for (int i = 0; i < tempRound && poolSize<n; i++) {
                    newMatingPool[poolSize++]=randMatrix[val];
                }
            }
            if (poolSize>=n)break;
        }

        return newMatingPool;
    }

    private static int[][] rankBasedSelection2(int[][] randMatrix, int[] decOfRandMatrix){

        int n=decOfRandMatrix.length;
        int m=randMatrix[0].length;
        double[]rank=new double[n];
        double avg;
        int poolSize=0;
        int newMatingPool[][]=new int[n][];
        TreeMap<Double,Integer>map=new TreeMap<>();
        for (int i = 0; i < n; i++) {
            rank[i]=quadraticEquation(decOfRandMatrix[i]);
        }
        avg=avg(rank);
        for (int i = 0; i < n; i++) {
            rank[i]=rank[i]/avg;
            map.put(rank[i],i);
        }
        Set<Double> rankSet=map.keySet();

        Iterator<Double>itr=rankSet.iterator();
        while (itr.hasNext()){
            double temp=itr.next();
            if (Math.round(temp)>0){
                int tempRound= (int) Math.round(temp);
                int val=map.get(temp);
                for (int i = 0; i < tempRound && poolSize<n; i++) {
                    newMatingPool[poolSize++]=randMatrix[val];
                }
            }
            else {
                int tempRound= (int) Math.ceil(temp);
                int val=map.get(temp);
                for (int i = 0; i < tempRound && poolSize<n; i++) {
                    newMatingPool[poolSize++]=randMatrix[val];
                }
            }
            if (poolSize>=n)break;
        }
        return newMatingPool;

    }


    static int[] randBinaryArray(int n){
        int a[]=new int[n];
        Random rand=new Random();
        for (int i = 0; i < n; i++) {

            if (rand.nextBoolean())
                a[i]=1;
            else a[i]=0;
        }
        return a;
    }

    static int[][]randBinaryMatrix(int n,int m){
        int a[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i]= randBinaryArray(m);
        }
        return a;
    }

    static int binaryArrayToDecimal(int a[]){
        int n=a.length;
        int sum=0;
        for (int i = 0; i <n; i++) {
            sum+=a[i]*Math.pow(2,n-i-1);
        }
        return sum;
    }

    static int[] binaryMatrixToDecimalArray(int a[][]){
        int row=a.length,col=a[0].length;
        int ans[]=new int[row];
        for (int i = 0; i < row; i++) {
            ans[i]=binaryArrayToDecimal(a[i]);
        }
        return ans;
    }

    static double avg(int []a){
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        return sum/a.length;
    }

    static double avg(double []a){
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        return sum/a.length;
    }

    static double fitness(int a){
        int p=quadraticEquation(a);
        return 1/(1+p);
    }


}

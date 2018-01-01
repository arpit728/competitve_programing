package academics;

import java.io.*;
import java.util.Arrays;

/**
 * Created by arpit on 9/2/17.
 */
public class SC_Experiment_4 {


    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br=new BufferedReader(new FileReader("src/academics/input.txt"));
        int w1[],x1[],x2[],w2[],t,op,b,x[],w[];
        x1=inputArray(4);
        w1=inputArray(4);

        t=Integer.parseInt(br.readLine());
        op=multiply(x1,w1,t);
        System.out.println("Output = "+op);

        x=inputArray(2);
        w=inputArray(2);
        System.out.println("AND gate = " + gate(x, w, -2, 0));   //And gate
        System.out.println("OR gate = " + gate(x, w, -1, 0));   //or gate
        System.out.println("XOR gate = "+xorGate(x,w));        //xor gate
        br.readLine();//skip one line of input
        w=inputArray(2);//input weights ofr nand gate
        System.out.println("NAND gate = "+gate(x,w,1,0));
        System.out.println("NOR gate = "+gate(x,w,0,0));

    }

    private static int xorGate(int[] x, int[] w) throws IOException {

  /*
        x1----O//neuron1
          \  /  \
           \/   /O//neuron 3
           / \ /  \
        x2----O    \b=1

   */
        int x1[]=new int[2],a,b;
        //read weights for xor neuron 1
        w=inputArray(2);
        a=gate(x,w,0,0);
        //read weights for xor neuron 2
        w=inputArray(2);
        b=gate(x,w,0,0);
        x1[0]=a;
        x1[1]=b;
        //read weights for xor neuron 3
        w=inputArray(2);
        return gate(x1,w,1,0);
    }

    public static int gate(int[] x, int[] w, int b, int t){
        int ans=0;
        int n=x.length;
        for (int i = 0; i <n; i++) {
            ans+=x[i]*w[i];
        }
        ans+=b;
        return ans>=t?1:0;
    }

    public static int[] inputArray(int n) throws IOException {
        String s[]=br.readLine().split("\\s");
        int a[]=new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        return a;
    }
    private static int multiply(int[] x, int[] w, int t) {

        int sum=0;
        for (int i = 0; i < x.length; i++){

            sum+=x[i]*w[i];
        }
        return sum>t?1:0;
    }
}

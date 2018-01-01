package problems.apac;

import java.io.IOException;

/**
 * Created by arpit on 3/9/16.
 */
public class Experiment {

    public static void main(String[] args) throws IOException {

       /* BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            donations=new int[s.length];
            for (int i = 0; i <s.length; i++) {
                donations[i]=Integer.parseInt(s[i]);
            }
            System.out.println(maxDonations(donations));
        }*/

        System.out.println((1<<29));
    }

    public static int maxDonations(int[]donations){

        int excl=0,exclNew,incl=0,max1;
        int n=donations.length;

        for (int i = 0; i < n-1; i++) {

            exclNew=incl;
            incl=Integer.max(excl+ donations[i],incl);
            excl=exclNew;
            //System.out.println("incl = "+incl+" excl = "+excl+" i= "+(i+1));
        }

        max1=incl;
        incl=0;excl=0;

        for (int i = 1; i <n; i++) {

            exclNew=incl;
            incl=Integer.max(excl+ donations[i],incl);
            excl=exclNew;
            //System.out.println("incl = "+incl+" excl = "+excl+" i= "+(i+1));
        }

        return Integer.max(max1,incl);

    }


}
class BadNeighbors{
    public static int maxDonations(int[]donations){

        int excl=0,exclNew,incl=0,max1;
        int n=donations.length;

        for (int i = 0; i < n-1; i++) {

            exclNew=incl;
            incl=Integer.max(excl+ donations[i],incl);
            excl=exclNew;
            //System.out.println("incl = "+incl+" excl = "+excl+" i= "+(i+1));
        }

        max1=incl;
        incl=0;excl=0;

        for (int i = 1; i <n; i++) {

            exclNew=incl;
            incl=Integer.max(excl+ donations[i],incl);
            excl=exclNew;
            //System.out.println("incl = "+incl+" excl = "+excl+" i= "+(i+1));
        }

        return Integer.max(max1,incl);

    }

}
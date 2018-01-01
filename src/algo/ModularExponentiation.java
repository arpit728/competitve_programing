package algo;

/**
 * Created by hardCode on 4/24/2016.
 */
public class ModularExponentiation {
    static final int  M=2100000;

    public static void main(String[] args) {


        System.out.println(binaryExponentiation(2,12));
        //System.out.println(moduloExpo(3,5));
    }

   public static int binaryExponentiation(int base,int exp){
        int ans=1;
        while (exp>0){
            if (exp%2==1)
                ans=(ans*base)%M;
            base=(base*base)%M;
            exp>>=1;
        }
        return ans;
    }


    //This function calculates a^b%m where b is in power of 2
    static int moduloExpo(int b,int e){

        if (e==1)
            return b%M;
        else {
            int ans=((moduloExpo(b,e/2)%M) * (moduloExpo(b,e/2)%M))%M;
            return ans;
        }

    }
}

package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by hardCode on 3/20/2017.
 */
public class SS_Experiment_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        char []textMessage;
        int message[],key[],ct[];
        String s[];

        textMessage=br.readLine().toCharArray();
        s=new String[textMessage.length];
        message= encode(textMessage);
        key=randBinaryArray(message.length);
        ct=encrypt(message,key);
        message=decrrypt(ct, key);
        System.out.println("MESSAGE = "+ String.valueOf(textMessage));
        System.out.println("CIPHER = "+String.valueOf(decode(ct)));
        System.out.println("MESSAGE = "+String.valueOf(decode(message)));
    }

    private static int[] decrrypt(int[] ct, int[] key) {
        return encrypt(ct,key);
    }

    //For each consecutive 8 bits in array it will replace it with char with ascii value of decimal equivalent of eight bits.
    private static char[] decode(int[] ct) {

        StringBuilder sbr=new StringBuilder();
        StringBuilder sbr1=new StringBuilder();
        for (int i = 0; i <ct.length; i++) {
            sbr.append(ct[i]);
            if ((i+1)%8==0)
            {
                sbr1.append((char) (Integer.parseInt(sbr.toString(), 2)));
                sbr.setLength(0);
            }

        }
        return sbr1.toString().toCharArray();
    }

    //This function takes the sequence of message and replaces it with binary equivalent of ascii value
    private static int[] encode(char[] textMessage) {
        String[]s=new String[textMessage.length];
        StringBuilder sbr=new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            byte b=(byte)textMessage[i];
            String temp=Integer.toBinaryString(b);
            for (int j = 0; j < 8 - temp.length(); j++) {
                sbr.append(0);
            }
            sbr.append(temp);
            s[i]=sbr.toString();
            sbr.setLength(0);
        }
        for (int i = 0; i < s.length; i++) {
            sbr.append(s[i]);
        }
        int temp[]=new int[sbr.length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=Integer.parseInt(sbr.charAt(i)+"");
        }
        return temp;
    }


    private static int[] encrypt(int[] message, int[] key) {

        StringBuilder sbr=new StringBuilder();
        int ct[]=new int[message.length];
        for (int i = 0; i < message.length; i++) {
            ct[i]=message[i]^key[i];
        }
        return ct;
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

}

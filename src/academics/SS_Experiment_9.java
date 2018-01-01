package academics;

/**
 * Created by hardCode on 2/27/2017.
 */
public class SS_Experiment_9 {

    public static void main(String[] args) {

        String message="1110111010110101";
        String key[]={"11001110","10110111","11001001","10101001","10001001","11001011"};
        String cipherText=encrypt(message, key);
        System.out.println("Message     = "+message);
        System.out.println("Cipher text = "+cipherText);
        System.out.println("Message     = "+decrypt(cipherText,key));
    }

    private static String encrypt(String message,String[]key) {
        int l=Integer.parseInt(message.substring(0,8),2);
        int r=Integer.parseInt(message.substring(8,16),2);

        for (int i = 0; i <6 ; i++) {
            int temp=r;
            int k=Integer.parseInt(key[i],2);
            r^=k^l;
            l=temp;
        }

        int cipherText=(l<<8)|r;

        return Integer.toBinaryString(cipherText);
    }

    private static String decrypt(String cipherText, String[] key) {

        int l=Integer.parseInt(cipherText.substring(0,8),2);
        int r=Integer.parseInt(cipherText.substring(8,16),2);

        for (int i = 0; i <6 ; i++) {
            int temp=l;
            int k=Integer.parseInt(key[5-i],2);
            l^=k^r;
            r=temp;
        }
        int plainText=(l<<8)|r;

        return Integer.toBinaryString(plainText);
    }
}

package misc;

/**
 * Created by hardCode on 3/1/2017.
 */
public class DuplicatesInStringWithoutAdditionalDataStructure {

    public static void main(String[] args) {

        String s="arpitt";
        System.out.println(solve(s.toCharArray()));
    }

    private static boolean solve(char[] a) {
        int hash=0;
       // System.out.println("as"+Integer.toBinaryString(hash));
        for (int i = 0; i < a.length; i++) {
            if (((1<<(97-a[i]))&hash)>0)return false;

            else
                hash|=1<<(97-a[i]);
            System.out.println(Integer.toBinaryString(hash));
        }

        return true;
    }

}

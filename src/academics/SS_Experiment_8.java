package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by hardCode on 2/20/2017.
 */
public class SS_Experiment_8 {


    public static void main(String[] args) throws IOException {
        String message;
        char[] key;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        message=br.readLine();
        key=br.readLine().toCharArray();
        System.out.println(encrypt(key,message));
    }

    private static String encrypt(char[] key, String message) {

        //remove space from alphabets
        message=message.replace(" ","");
        //remove duplicates from the keys
        key=removeDuplicates(key);

        //This set will store all the characters accept those are already included in keys.
        LinkedHashSet<Character>alphabets=getAlphabetsWithoutKey(key);
        HashMap<Character,Integer>characterLocationHashMap=new HashMap<>();
        char[][]keyMatrix=getKeyMatrix(key,alphabets,characterLocationHashMap);

        //insert x between rwo repeated characters
        message=insertX(message);


        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(keyMatrix[i]));
        }
        return null;
    }

    private static String insertX(String message) {

        StringBuilder sbr=new StringBuilder();
        for (int i = 0; i < sbr.length()-1; i++) {
            if (sbr.charAt(i)==sbr.charAt(i+1))sbr.insert(i,'x');
        }
        if ((sbr.length()&1)==1)sbr.append('x');
        return sbr.toString();
    }

    private static char[][] getKeyMatrix(char[] key, LinkedHashSet<Character> alphabets, HashMap<Character, Integer> characterLocationHashMap) {

        char a[][]=new char[5][5];
        int count=0;
        Iterator ch=alphabets.iterator();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (count<key.length){
                    a[i][j]=key[count];
                }
                else a[i][j]= (char) ch.next();
                count++;
                characterLocationHashMap.put(a[i][j],count);
            }
        }

        return a;
    }

    private static LinkedHashSet<Character> getAlphabetsWithoutKey(char[] key) {

        LinkedHashSet<Character>set=new LinkedHashSet<>();

        for (int i = 0; i < 26; i++) {
            set.add((char) (97+i));
        }
        set.remove('j');

        for (int i = 0; i < key.length; i++) {
            set.remove(key[i]);
        }

        return set;
    }

    private static char[] removeDuplicates(char[] key) {

        LinkedHashSet<Character>set=new LinkedHashSet<>();
        for (int i = 0; i < key.length; i++) {
            set.add(key[i]);
        }
        char[]newKey=new char[set.size()];
        int i=0;
        for (Character c:set){
            newKey[i]=c;
            i++;
        }
        return newKey;

    }


}

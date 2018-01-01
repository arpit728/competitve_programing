package academics;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by hardCode on 2/16/2017.
 */
public class SC_Experiment_3 {

    public static void main(String[] args) {
        Character[] commonElements = {'a' ,'b', 'c' , 'd' , 'e' , 'f' , 'g'};

        HashMap<Character , Double> set1  = new HashMap<>();
        HashMap<Character , Double> set2  = new HashMap<>();
        HashMap<Character , Double> set3  = new HashMap<>();

        for (Character commonElement : commonElements) {
            double random = Math.random();
            double random2 = Math.random();
            set1.put(commonElement , random);
            set2.put(commonElement , random2);
            set3.put(commonElement , random2);
        }


        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);


        System.out.println("\n--Union--");
        System.out.println(union(set1 , set2));

        System.out.println("\n--Intersection--");
        System.out.println(intersection(set1 , set2));

        System.out.println("\n--Complement--");
        System.out.println(complement(set1));

        System.out.println("\n--differnce--");
        System.out.println(difference(set1, set2));

        System.out.println("\n--Composition--");

        Double[][] crossProduct = minCrossProduct(set1, set2);
        Double[][] crossProduct2 = minCrossProduct(set2,set3);
        Double[][] composition = composition(crossProduct, crossProduct2);
        for (int i = 0; i < crossProduct.length; i++) {
            for (int j = 0; j < crossProduct[0].length; j++) {
                System.out.print(composition[i][j] + ", ");
            }
            System.out.println();
        }


    }

    private static  Double[][]  composition(Double[][] crossProduct, Double[][] crossProduct2) {

        if(crossProduct[0].length != crossProduct2.length ){
            System.err.println("Matrix size incompatible");
            return null;
        }

        Double[] doubles1 = new Double[crossProduct2[0].length];
        Double[] doubles2;
        Double[][] res = new Double[crossProduct.length][crossProduct2[0].length];
        for (int i = 0; i < crossProduct.length; i++) {
            for (int j = 0; j < crossProduct2[0].length; j++) {


                Double min[] = new Double[crossProduct[0].length];

                for (int k = 0; k < min.length; k++) {
                    Double aDouble = crossProduct[i][k];
                    Double bDouble = crossProduct[k][j];
                    min[k] = aDouble <= bDouble ? aDouble : bDouble;
                }

                Arrays.sort(min);
                res[i][j] = min[min.length - 1];

            }
        }

        return res;
    }

    private static Double[][] minCrossProduct(HashMap<Character, Double> set1, HashMap<Character, Double> set2) {
        Double[][] res = new Double[set1.size()][set2.size()];


        int j;
        int i = 0;
        Double aDouble;
        Double bDouble;


        for (Character character : set1.keySet()) {
            j = 0;
            aDouble = set1.get(character);
            for (Character character1 : set2.keySet()) {
                bDouble = set2.get(character1);
                res[i][j] = aDouble<=bDouble?aDouble:bDouble ;
                j++;
            }

            i++;
        }



        return res;
    }

    private static HashMap<Character, Double> difference(HashMap<Character, Double> set1, HashMap<Character, Double> set2) {
        HashMap<Character, Double> complemented = complement(set2);
        HashMap<Character, Double> res = intersection(set1, complemented);
        return  res;
    }

    private static HashMap<Character, Double> complement(HashMap<Character, Double> set1) {

        HashMap<Character , Double> set3  = new HashMap<>();

        for (Character character : set1.keySet()) {
            Double aDouble = set1.get(character);
            set3.put(character, 1 - aDouble);
        }

        return set3;

    }

    private static HashMap<Character, Double> union(HashMap<Character, Double> set1, HashMap<Character, Double> set2) {


        HashMap<Character , Double> set3  = new HashMap<>();

        for (Character character : set1.keySet()) {
            Double aDouble = set1.get(character);
            Double bDouble = set2.get(character);

            set3.put(character, aDouble>=bDouble?aDouble:bDouble);
        }

        return set3;
    }


    private static HashMap<Character, Double> intersection(HashMap<Character, Double> set1, HashMap<Character, Double> set2) {


        HashMap<Character , Double> set3  = new HashMap<>();

        for (Character character : set1.keySet()) {
            Double aDouble = set1.get(character);
            Double bDouble = set2.get(character);

            set3.put(character, aDouble<=bDouble?aDouble:bDouble);
        }

        return set3;
    }

}

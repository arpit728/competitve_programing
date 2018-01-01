package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by hardCode on 4/30/2016.
 */
public class GettingtheDigits {

    public static void main(String[] args) throws IOException {
        int t;
        String inp;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,String>map=new HashMap<>();

        map.put(0,"ZERO");
        map.put(1,"ONE");
        map.put(2,"TWO");
        map.put(3,"THREE");
        map.put(4,"FOUR");
        map.put(5,"FIVE");
        map.put(6,"SIX");
        map.put(7,"SEVEN");
        map.put(8,"EIGHT");
        map.put(9,"NINE");

        t=Integer.parseInt(br.readLine());
        int i=1;
        while (t-->0){
            inp=br.readLine();
            System.out.println("Case #"+i+": "+solve(map,inp));
            i++;
        }



    }

    private static String solve(HashMap<Integer, String> map, String inp) {

        int hash[]=new int[125];
        ArrayList<Character> indices=new ArrayList<>();
        StringBuilder sbr=new StringBuilder(inp);
        SortedSet<Integer>values=new TreeSet<>();
        for (int i = 0; i<inp.length(); i++) {
            hash[inp.charAt(i)]++;
            //System.out.println(hash[inp.charAt(i)]);
        }
        System.out.println(hash['O']);
        int len=sbr.length();

        while (len>0)
        for (int i = 0; i < 10; i++) {
            String s=map.get(i);
            int count=0;

            for (int j = 0; j < s.length(); j++) {

                if (hash[s.charAt(j)]>0){
                    count++;
                    indices.add(s.charAt(j));
                    //System.out.print(s.charAt(j)+" ");
                }
                System.out.println(s+" "+hash[s.charAt(j)]+" "+s.charAt(0));
            }


            if (count==s.length())
            {
                values.add(i);

                for (int j = 0; j < indices.size(); j++) {
                    len--;
                    hash[indices.get(j)]--;
                }


                indices.clear();

            }

        }
        ArrayList<Integer>list=new ArrayList<>(values);
        StringBuilder ans=new StringBuilder();

        for (int i = 0; i <list.size(); i++) {
            ans.append(list.get(i));
        }

        return ans.toString();
        //old logic begins here

       /* SortedSet<Integer>set=new TreeSet<>();
        StringBuilder sbr=new StringBuilder(inp);
        ArrayList<Integer>indices=new ArrayList<>();

        while (sbr.length()>0)
            for (int i = 0; i < 10; i++) {
                String s=map.get(i);
                int  count=0;
                for (int j = 0; j < s.length(); j++) {
                    int ind=sbr.indexOf(s.charAt(j)+"");
                    if (ind!=-1){
                        count++;
                        indices.add(j);
                        System.out.println(sbr);
                    }
                    else break;
                }
                if (count==s.length()){
                    set.add(i);
                    for (int j = 0; j < indices.size()-1; j++) {
                        System.out.println(s+indices);
                        sbr.deleteCharAt(indices.get(j));
                        indices.add(j+1,indices.get(j+1)-1);
                    }

                }
                indices.clear();
            }

        ArrayList<Integer>list=new ArrayList<>(set);
        StringBuilder ans=new StringBuilder();

        for (int i = 0; i <list.size(); i++) {
            ans.append(list.get(i));
        }*/


    }
}

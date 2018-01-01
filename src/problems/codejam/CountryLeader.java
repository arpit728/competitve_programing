package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by hardCode on 7/10/2016.
 */
public class CountryLeader {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Person> p=new PriorityQueue<>(20);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,i=1;
        String s;
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            int count;
            for (int j = 0; j <n; j++) {
                s=br.readLine();
                count=differentCharacters(s.toCharArray());
                p.add(new Person(count, s));
            }
            //System.out.println(p);
            System.out.println("Case #"+i+": "+p.peek().name);
            p.clear();
            i++;
        }


    }

    private static int differentCharacters(char[] ch) {

        boolean hash[]=new boolean[126];
        int n=ch.length,count=0;

        for (int i = 0; i < n; i++) {

            if (ch[i]!=' ')
            if (!hash[ch[i]]){
                count++;
                hash[ch[i]]=true;
            }
        }
        return count;
    }
}

class Person implements Comparable<Person>{

    Integer diffCharacters;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "diffCharacters=" + diffCharacters +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(Integer diffCharacters, String name) {
        this.diffCharacters = diffCharacters;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.diffCharacters==o.diffCharacters)return this.name.compareTo(o.name);

        else return o.diffCharacters.compareTo(this.diffCharacters);
    }
}

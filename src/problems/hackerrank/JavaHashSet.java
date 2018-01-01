package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by hardCode on 7/12/2016.
 */

class A{
    String s1,s2;
    A(String s1,String s2){
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public int hashCode() {
        return s1.hashCode()+s2.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof A){
            A a= (A) obj;
            if (this.s1.equals(a.s1) && this.s2.equals(a.s2))return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "A{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }
}
public class JavaHashSet {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[];
        int n;
        n=Integer.parseInt(br.readLine());
        HashSet<A> set=new HashSet<>();
        for(int i=0;i<n;i++){

            s=br.readLine().split("\\s");
            set.add(new A(s[0], s[1]));
            System.out.println(set.size());
        }
        System.out.println(set);

    }


}

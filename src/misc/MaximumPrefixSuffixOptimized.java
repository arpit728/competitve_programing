package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by arpit on 21/8/16.
 */
public class MaximumPrefixSuffixOptimized {


    static long prefix[]=new long[100002];
    static long suffix[]=new long[100002];
    static long a[]=new long[100002];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;

        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");

        for (int i = 1; i <=n; i++) a[i]= Integer.parseInt(s[i-1]);

        System.out.println(solve(n));

    }


    private static long solve(int n) {

        for (int i =n; i>0; i--) suffix[i]=suffix[i+1]^a[i];

        for (int i = 1; i <=n ; i++) prefix[i]=prefix[i-1]^a[i];

        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(prefix));

        long result=0;

        Trie t=new Trie();
        t.root=new Trie.Node();
        t.insert(0);
        t.traverse();

        for (int i = 0; i <=n; i++) {
            t.insert(suffix[i]);
        }

        t.traverse();
        /*for (int i =n; i>=0 ; i--) {


            t.insert(suffix[i+1]);
            t.traverse();

            result=max(result, t.query(prefix[i]));

            System.out.println("result = "+result);
        }*/

        //System.out.println("prefix = "+ Arrays.toString(prefix)+" Suffix = "+Arrays.toString(suffix));
        return result;
    }

    private static long max(long result, long l) {

        return result>l?result:l;

    }


}

class Trie{

    Node root;

    static class Node{
        long value=-1;
        Node[]arr=new Node[2];
    }

    void insert(long suffXor){
        Node temp=this.root;

        for (int i = 42 ; i>=0 ;i--) {

            long x= suffXor&(1L<<i);

            int ind=(x>=1?1:0);

            if (temp.arr[ind]==null)
                temp.arr[ind]=new Node();

            temp=temp.arr[ind];
        }
        temp.value=suffXor;

    }

    long query(long pre){

        Node temp=this.root;

        for (int i = 42; i>=0; i--) {

            long x=(1L<<i)&pre;

            int ind=(x>=1?1:0);

            if (temp.arr[1-ind]!=null)temp=temp.arr[1-ind];

            else if (temp.arr[ind]!=null)temp=temp.arr[ind];
        }

        return temp.value^pre;
    }

    void traverse(){

        Node temp=this.root;

        Stack<Node>stack=new Stack<>();

        stack.push(temp);

        while (!stack.isEmpty()){

            temp=stack.pop();

            if (temp.value!=-1)System.out.print(temp.value + " ");

            if (temp.arr[1]!=null)stack.push(temp.arr[1]);

            else if (temp.arr[0]!=null)stack.push(temp.arr[0]);
        }
        System.out.println();
    }

}


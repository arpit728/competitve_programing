package algo.dp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by arpit on 15/12/16.
 */
public class MaxXorSubArray {

    static int a[]=new int[100000];


    public static void main(String[] args) throws IOException {

        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int t,n;
        String[]s;
        t=sc.nextInt();
        while (t-->0){
            n=sc.nextInt();
            //s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=sc.nextInt();
                //a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(n));
        }

    }

    private static int solve(int n) {
        Trie trie=new Trie();
        int pre=0,ans=0;
        trie.insert(0);
        for (int i = 0; i < n; i++) {
            pre^=a[i];
            System.out.println(trie.query(pre));
            ans=Integer.max(trie.query(pre),ans);
            trie.insert(pre);
        }
        return ans;
    }

    static class Trie{

        TrieNode root;

        public Trie() {
            root=new TrieNode();
        }

        class TrieNode{
            int val;
            TrieNode[]child;

            public TrieNode() {
                child=new TrieNode[2];
            }
        }

        int query(int key){

            TrieNode temp=root;
            for (int i = 31; i>=0; i--) {
                int currbit;

                if ( (key&(1<<i) )>=1)currbit=1;

                else currbit=0;

                if (temp.child[1-currbit]!=null){
                    temp=temp.child[1-currbit];
                    //System.out.println(temp);
                }

                else if (temp.child[currbit]!=null){
                    temp=temp.child[currbit];
                }
            }
            return temp.val^key;
        }

        void insert(int key){

            TrieNode temp=root;
            for (int i = 31; i>=0 ; i--) {
                int currBit;

                if ((key&(1<<i))>=1) currBit = 1;

                else currBit=0;

                if (temp.child[currBit]==null){
                    temp.child[currBit]=new TrieNode();
                    temp=temp.child[currBit];
                }

                else
                    temp=temp.child[currBit];
            }
            temp.val=key;

        }
    }

}

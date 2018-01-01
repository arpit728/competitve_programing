package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/26/2017.
 */
public class MaxXorSubarrayModified {

   static int a[] = new int[10000];
   static int pre[] = new int[10000];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //String[] s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            pre[0] = a[0];
            //System.out.print(pre[0]+" ");
            for (int i = 1; i < n; i++) {
                pre[i] = a[i] ^ pre[i - 1];
                //System.out.print(pre[i]+" ");
            }
            System.out.println(solve(pre,a,n));
        }

    }

    private static int solve(int[] pre, int[] a, int n) {

        Trie1 root= new Trie1();
        root.insert(0);
        //System.out.println("Zero inserted");
        int max=0;
        for (int i = 0; i < n; i++) {
            root.insert(pre[i]);
        }
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, root.query(pre[i]));
            //System.out.println(i+" worked successfully");
        }
        return max;
    }
}

class Trie1{

    TrieNode root;

    public Trie1() {
        root = new TrieNode();
    }

    static class TrieNode{
        TrieNode[]trieNode;

        public TrieNode() {
            trieNode = new TrieNode[2];
        }
    }

    void insert(int x){
        TrieNode temp=root;

        for (int i = 31; i>=0 ; i--) {
            int currentBit = (x >> i) & 1;
            if (temp.trieNode[currentBit] == null) {
                temp.trieNode[currentBit] = new TrieNode();
            }
            temp = temp.trieNode[currentBit];
        }
    }

    int query(int key) {
        int ans=0;
        TrieNode temp=root;
        for (int i = 31; i>=0 ; i--) {
            int currentBit = (key >> i) & 1;
            if (temp.trieNode[1 - currentBit] != null) {
                ans|=(1-currentBit)<<i;
                temp = temp.trieNode[1 - currentBit];
            }
            else {
                ans |= currentBit << i;
                temp = temp.trieNode[currentBit];
            }
        }
        return ans^key;
    }
}
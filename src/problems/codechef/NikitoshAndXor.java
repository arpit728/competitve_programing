package problems.codechef;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by arpit on 16/12/16.
 */
public class NikitoshAndXor {

    static final int MAX=400011;
    static int a[]=new int[MAX],maxPrefix[]=new int[MAX],maxSuffix[]=new int[MAX];
    static Reader r=new Reader();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        //n=Integer.parseInt(br.readLine());
        n=r.nextInt();
        //s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            //xenny[i]=Integer.parseInt(s[i]);
            a[i]=r.nextInt();
           /* maxPrefix[i]=xenny[i];
            maxSuffix[i]=xenny[i];*/
        }
        System.out.println(solve(n));

    }

    private static long solve(int n) {
        maxPrefix[0]=a[0];
        maxSuffix[n-1]=a[n-1];
        fillMaxPrefix(n);
        fillMaxSuffix(n);
        long ans=Integer.MIN_VALUE;

        for (int i = 0; i < (n - 1); i++)
            ans = Long.max(ans, maxPrefix[i] + maxSuffix[i + 1]);

        return ans;
    }

    private static void fillMaxSuffix(int n) {
        Trie suffixTrie=new Trie();
        int suff=a[n-1];
        suffixTrie.insert(0);
        suffixTrie.insert(a[n-1]);
        for (int i = n-2; i>=0; i--) {
            suff^=a[i];
            maxSuffix[i]=Integer.max(maxSuffix[i+1], suffixTrie.query(suff));
            suffixTrie.insert(suff);
        }
    }

    private static void fillMaxPrefix(int n) {
        Trie prefixTrie = new Trie();
        int pre=a[0];
        prefixTrie.insert(0);
        prefixTrie.insert(a[0]);
        for (int i = 1; i < n; i++) {
            pre^=a[i];
            //System.out.println(prefixTrie.query(pre));
            maxPrefix[i]=Integer.max(maxPrefix[i-1],prefixTrie.query(pre));
            prefixTrie.insert(pre);
        }
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
        void insert(int key){

            TrieNode temp=root;
            for (int i = 31; i>=0; i--) {
                int currBit;
                if ((key&(1<<i))>=1)currBit=1;
                else currBit=0;

                if (temp.child[currBit]!=null){
                    temp=temp.child[currBit];
                }
                else{
                    temp.child[currBit]=new TrieNode();
                    temp=temp.child[currBit];
                }
            }
            temp.val=key;
        }

        int query(int key){
            TrieNode temp=root;
            for (int i = 31; i>=0; i--) {
                int currBit;
                if ((key&(1<<i))>=1)currBit=1;
                else currBit=0;

                if (temp.child[1-currBit]!=null){
                    temp=temp.child[1-currBit];
                }
                else if (temp.child[currBit]!=null){
                    temp=temp.child[currBit];
                }
                else break;
            }
            return temp.val^key;
        }
    }
}
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }


    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}
package misc;

/**
 * Created by arpit on 15/12/16.
 */
public class MinXorPair {

    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 3, 4, 5};

        System.out.println(solve(a,a.length));

    }

    private static int solve(int[] a, int n) {
        int minXor=Integer.MAX_VALUE;

        Trie trie=new Trie();
        trie.insert(a[1]);
        for (int i = 1; i <n; i++) {
            minXor=Integer.min(trie.getMinXor(a[i]),minXor);
            trie.insert(a[i]);
        }
        return minXor;
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        class TrieNode {
            int value;
            TrieNode child[];

            public TrieNode() {
                child = new TrieNode[2];
                child[0] = null;
                child[1] = null;
            }
            public TrieNode(TrieNode t) {
                this.child=t.child;
                this.value=t.value;
            }

        }

        public void insert(int key) {

            TrieNode temp = root;
            for (int i = 31; i >= 0; i--) {
                int currBit;
                if ((key & (1 << i))>=1)
                 currBit = 1;
                else currBit=0;
                if (temp.child[currBit] == null) {
                    temp.child[currBit] = new TrieNode();
                    temp = temp.child[currBit];
                } else temp = temp.child[currBit];
            }
            temp.value = key;
        }

        public int getMinXor(int key) {
            TrieNode temp = root;

            for (int i = 31; i >= 0; i--) {
                int currBit;
                if ((key & (1 << i))>=1)
                    currBit = 1;
                else currBit=0;
                if (temp.child[currBit] != null){
                    temp = temp.child[currBit];
                }

                else temp = temp.child[1-currBit];
            }
            return key ^ temp.value;
        }

    }

}



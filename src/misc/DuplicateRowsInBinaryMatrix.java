package misc;

import java.io.IOException;

/**
 * Created by bugkiller on 9/14/2017.
 */
public class DuplicateRowsInBinaryMatrix {

    static int a[][] = {{1, 1, 0, 1, 0, 1},
                 {0, 0, 1, 0, 0, 1},
                 {1, 0, 1, 1, 0, 0},
                 {1, 1, 0, 1, 0, 1},
                 {0, 0, 1, 0, 0, 1},
                 {0, 0, 1, 0, 0, 1}};

    public static void main(String[] args) throws IOException {
        Trie2 trie = new Trie2();
        System.out.print("Duplicate rows : ");
        for (int i = 0; i < a.length; i++) {
            if (trie.insert(a, i)) System.out.print((i + 1) + " ");
        }
    }
}

class Trie2{

    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    class TrieNode{
        TrieNode []trieNode;
        boolean isLeaf;
        public TrieNode() {
            trieNode = new TrieNode[2];
        }
    }

    public boolean insert(int[][] a, int i) {

        TrieNode temp = root;
        for (int j = 0; j < a[0].length; j++) {
            int currentBit = a[i][j];
            if (temp.trieNode[currentBit] == null) {
                temp.trieNode[currentBit] = new TrieNode();
            }
            temp = temp.trieNode[currentBit];
        }
        if (temp.isLeaf) {
            return true;
        }
        else {
            temp.isLeaf = true;
            return false;
        }
    }
}

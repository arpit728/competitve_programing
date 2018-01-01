package academics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by arpit on 30/1/17.
 */
public class SS_Experiment_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] pt,key;
        pt=br.readLine().toCharArray();
        key=br.readLine().toCharArray();
        Pair []pairKey=getIntegerPairKey(pt,key);
        int rows=pt.length/pairKey.length+1;
        char rowEnc[][]=new char[rows][pairKey.length];

        int k=0;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < pairKey.length; j++) {
                if (k<pt.length)
                    rowEnc[i][j]=pt[k++];
                else rowEnc[i][j]='#';
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(rowEnc[i]));
        }
        StringBuilder sbr=new StringBuilder();

        for (int i = 0; i < pairKey.length; i++) {
            for (int j = 0; j < rows; j++) {
                char c=rowEnc[j][pairKey[i].idx];
                if (c!='#')
                    sbr.append(rowEnc[j][pairKey[i].idx]);
            }
        }
        System.out.println(sbr);

    }

    private static Pair[] getIntegerPairKey(char[] pt, char[] key) {
        char keyCopy[]= Arrays.copyOf(key,key.length);
        Pair []p;
        Arrays.sort(keyCopy);
        LinkedHashMap<Character,Integer> map= new LinkedHashMap<>();
        int rank=0;
        for (int i = 0; i < key.length; i++) {
            if (!map.containsKey(key[i])){
                map.put(key[i],rank++);
            }
        }
        p=new Pair[map.size()];
        Character x[]=new Character[map.size()];
        map.keySet().toArray(x);

        System.out.println(map.size());
        for (int i = 0; i < map.size(); i++) {
            p[i]=new Pair(i,map.get(x[i]));
        }
        Arrays.sort(p);
        return  p;
    }

    static class Pair implements Comparable<Pair>{
        int idx,val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair pair)
        {
            return ((Integer)this.val).compareTo(pair.val);
        }
    }
}

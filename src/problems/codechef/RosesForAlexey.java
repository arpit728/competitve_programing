package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by arpit on 4/12/16.
 */

public class RosesForAlexey {

    final static int MAX=100000;

    final static LinkedList<Long> a=new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        String s[];
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);

            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(s[i]));
            }

            System.out.println(solve(n,k));
        }
    }

    private static int solve(int n, int k) {

        HashMap<Long, Integer> map=new HashMap<>();
        initMap(map,n);
        Long keySet[]=new Long[map.size()];
        Pair pair[]=new Pair[map.size()];

        map.keySet().toArray(keySet);
        n=normalizeMap(map,keySet,n,k);
        fillPair(map,keySet, pair);

        Arrays.sort(pair);
        Collections.sort(a);

        map.clear();
        keySet=null;

        return newFlowerCut(pair,n,k);

    }

    private static int newFlowerCut(Pair[] pair, int n, int k) {

        int temp,start,totalCut=0;
        for (int i = 0; i < pair.length; i++) {
            start=getStartIndex(pair[i].key,n);
            totalCut+=crop(start,pair[i].key,pair[i].value,n,k);
            n=a.size();
        }
        return totalCut;
    }

    private static void fillPair(HashMap<Long, Integer> map1, Long[] keySet, Pair[] pair) {

        for (int i = 0; i < keySet.length; i++) {
            pair[i]=new Pair(keySet[i],map1.get(keySet[i]));
        }

    }

    private static void initMap(HashMap<Long, Integer> map, int n) {

        int temp;
        for (int i = 0; i < n; i++) {

            if (map.containsKey(a.get(i))){
                temp= map.get(a.get(i));
                temp++;
                map.put(a.get(i),temp);
            }
            else map.put(a.get(i),1);
        }

    }

    private static int crop(int start, Long item, Integer itemCount, int n, int k) {

        int cut=0;
        if (start<(n-k+1)){
            cut=k-itemCount;
            for (int j =0; j<k; j++) {
                a.remove(start);
            }
        }
        return cut;
    }

    private static int getStartIndex(Long item, int n) {
        for (int i = 0; i < n; i++) {
            if (a.get(i) ==item)return i;
        }
        return 0;
    }

    private static int normalizeMap(HashMap<Long, Integer> map, Long[] keySet, int n, int k) {

        int keyCount=keySet.length,quotient,newSize=n,start;

        for (int i = 0; i <keyCount; i++) {

            int temp=map.get(keySet[i]);
            quotient=temp/k;

            if (quotient>0){
                start=getStartIndex(keySet[i],n);
                removeSimilarElements(start,k*quotient);
                newSize-=k*quotient;
                temp=temp%k;
                map.put(keySet[i],temp);
            }
        }
        return newSize;
    }

    private static void removeSimilarElements(int start, int count) {
        for (int i = 0; i < count; i++) {
            a.remove(start);
        }

    }

    static class Pair implements Comparable<Pair>{
        Long key;
        Integer value;

        public Pair(Long key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair pair) {
            return pair.value.compareTo(this.value);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


}


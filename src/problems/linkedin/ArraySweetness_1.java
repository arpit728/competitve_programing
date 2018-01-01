package linkedin;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by arpit on 5/11/16.
 */
public class ArraySweetness_1 {

    public static void main(String[] args) {

        System.out.println(new ArraySweetness_1().solution(new int[]{2,3,4,1,1,2,3}));
    }

    public int solution(int a[]){

        int weight=0;
        int n=a.length;
        Element e[]=new Element[a.length];

        for (int i = 0; i <n; i++) {
            e[i]=new Element(a[i],i);
        }
        Arrays.sort(e);

        //System.out.println(Arrays.toString(e));

        TreeMap<Integer,Pair> treeMap=new TreeMap<>();

        for (int i = 0; i < a.length; i++) {
            if (treeMap.containsKey(e[i].d)){
                Pair p=treeMap.get(e[i].d);
                p.setMax(e[i].index);
                continue;
            }
            treeMap.put(e[i].d,new Pair(e[i].index,e[i].index));
        }

        //System.out.println(treeMap);

        int dis=Integer.MIN_VALUE;
        int min,max;

        while (!treeMap.isEmpty()){
            Pair temp=treeMap.remove(treeMap.firstKey());

            min=temp.getMin();
            max=temp.getMax();

            weight+=(max-min);

        }
        return weight;
    }
    static class Element implements Comparable<Element>{
        int d,index;

        public Element(int d, int index) {
            this.d = d;
            this.index = index;
        }

        @Override
        public int compareTo(Element element) {
            Integer a=this.d,b=element.d;
            return a.compareTo(b);
        }

        @Override
        public String toString() {
            return "Element{" +
                    "d=" + d +
                    ", index=" + index +
                    '}';
        }
    }
    static class Pair{
        int min,max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}

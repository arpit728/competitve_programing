package misc;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by arpit on 11/9/16.
 */
public class AdjacentElements {

    public static void main(String[] args) {

        System.out.println(new AdjacentElements().solution(new int[]{1,2,3,4,5,1,2,3,4,5}));
    }

    public int solution(int a[]){

        int n=a.length;
        Element e[]=new Element[a.length];

        for (int i = 0; i <n; i++) {
            e[i]=new Element(a[i],i);
        }
        Arrays.sort(e);

        //System.out.println(Arrays.toString(e));

        TreeMap<Integer,Pair>treeMap=new TreeMap<>();

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
        Pair p=treeMap.remove(treeMap.firstKey());
        int min1,max1,min2,max2;
        min1=p.getMin();max1=p.getMax();
        while (!treeMap.isEmpty()){
            Pair temp=treeMap.remove(treeMap.firstKey());
            min2=temp.getMin();
            max2=temp.getMax();
            dis=Integer.max(dis,Integer.max(Math.abs(max2-min1),Math.abs(min2-max1)));
            min1=min2;
            max1=max2;
        }
        return dis;
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

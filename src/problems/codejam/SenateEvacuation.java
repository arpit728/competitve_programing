package problems.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hardCode on 5/8/2016.
 */
public class SenateEvacuation {
    static char ch[]=new char[50];
    public static void main(String[] args) throws IOException {

        int t,i=0,n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        String s[];
        data a[]=new data[26];;

        for (int j = 0; j < 26; j++) {
            ch[i]= (char) (65+i);
            a[j]=new data();
        }

        while(t-->0){

            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            int sum=0,m;
            for (int j = 0; j <n; j++) {
                a[j].setCh(ch[j]);
                m=Integer.parseInt(s[j]);
                a[j].setN(m);
                a[j].setIndex(j);
                System.out.println(a[j]);
                sum+=m;
            }
            System.out.println(solve(a,n,sum));
        }
    }

    private static String solve(data[] a, int i, int sum) {
        StringBuilder ans=new StringBuilder();
        int m=0,p,index;
        ArrayList<Integer> list=null;

        while (sum!=0){
            m=(sum-2)/2;
            list=getIndices(a,m);
            System.out.println(list+" "+sum);
            if (list.size()==1){
                sum-=2;
                index=list.get(0);
                p=a[index].getN();
                a[index].setN(p-2);
                ans.append(a[index].getCh());
                ans.append(a[index].getCh());
                ans.append(" ");
            }
            else if (list.size()>=1){
                index=list.get(0);
                boolean flag=false;
                if (a[index].getN()>0){
                    sum--;
                    p=a[index].getN();
                    a[index].setN(p-1);
                    ans.append(a[index].getCh());
                    flag=true;

                }
                list.remove(0);
                if (a[index].getN()>0){
                    if (!flag)ans.append(" ");
                    sum--;
                    p=a[index].getN();
                    a[index].setN(p-1);
                    ans.append(a[index].getCh());
                    ans.append(" ");
                }
            }
        }

        return ans.toString();
    }

    private static ArrayList getIndices(data[] a, int m) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Arrays.sort(a);
        for (int i = 0; i < 26; i++) {
            if (a[i].getN()>=m)arrayList.add(a[i].getIndex());
        }
        return arrayList;
    }

    static class data implements Comparable<data>{
        int n,index;
        char ch;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public data() {
        }

        public int getN() {
            return n;
        }

        public char getCh() {
            return ch;
        }

        public data(int n, char ch) {
        this.n = n;
        this.ch = ch;
        }

        public void setN(int n) {
            this.n = n;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        @Override
        public String toString() {
            return "data{" +
                    "n=" + n +
                    ", index=" + index +
                    ", ch=" + ch +
                    '}';
        }

        @Override
        public int compareTo(data o) {

            if (this.getN()<o.getN())return -1;
            else return 1;
        }
    }
}

package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Arpit on 16-Dec-15.
 */
public class NumberOfFactors {

    static final int MAX=1000001;
    static int factors[]=new int[MAX];
    static void sieve(){
        for (int i=2;i<MAX;i+=2){
            factors[i]=2;
        }
        for (int i=3;i<MAX;i+=2){
            if (factors[i]==0){
                factors[i]=i;
                for (int j = i*i; j < MAX&&j>0; j+=2*i) {
                    if (factors[j]==0){
                        factors[j]=i;
                    }
                }
                //System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        sieve();

        int t,n,number,ans;

        try {
            t= Integer.parseInt(br.readLine());

            for (int i = 0; i <t; i++) {

                n=Integer.parseInt(br.readLine());
                String[]s=br.readLine().split("\\s");
                HashMap<Integer,Integer>map=new HashMap<>();
                ans=1;

                for (int j=0;j<n;j++){
                    number=Integer.parseInt(s[j]);
                    if (number==factors[number]){
                        if (map.containsKey(number)){
                            int a=map.get(number);
                            a++;
                            map.put(number,a);
                        }
                        else map.put(number,1);
                    }

                    else{
                        int temp=number,k,count=0;
                        while (temp>1){
                            k=temp;count=0;
                            while (temp%factors[k]==0){
                                count++;
                                temp/=factors[k];
                            }
                            if (map.containsKey(factors[k])){
                                int a=map.get(factors[k]);
                                a+=count;
                                map.put(factors[k],a);
                            }
                            else map.put(factors[k],count);
                        }

                    }
                }
                ArrayList<Integer>arr=new ArrayList<>(map.values());
                Iterator<Integer>itr=arr.iterator();
                while (itr.hasNext()){
                    ans=ans*(itr.next()+1);
                }
                arr.clear();
                System.out.println(ans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

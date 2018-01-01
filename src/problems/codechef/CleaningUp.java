package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Arpit on 26-Dec-15.
 */
public class CleaningUp {
        public static void main(String[] args) {
            int t,n,m;
            String s[];
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            try {
                t= Integer.parseInt(br.readLine());
                while (t-->0){

                    s=br.readLine().split("\\s");
                    n=Integer.parseInt(s[0]);
                    m=Integer.parseInt(s[1]);
                    s=br.readLine().split("\\s");
                    int list[]=new int[n+1];
                    byte turn=1;
                    ArrayList<Integer>chef=new ArrayList<>(n);
                    ArrayList<Integer>assis=new ArrayList<>(n);
                    for (int i = 0; i < m; i++) {
                        list[Integer.parseInt(s[i])]=-1;
                    }

                    for(int i = 1; i <=n; i++) {
                        if (list[i]==-1)continue;
                        else {
                            if (turn==1){
                                chef.add(i);
                                turn=2;
                            }
                            else {
                                assis.add(i);
                                turn=1;
                            }
                        }
                    }

                    Iterator<Integer>itr=chef.iterator();

                    while (itr.hasNext()){
                        System.out.print(itr.next() + " ");
                    }
                    System.out.println();
                    itr=assis.iterator();
                    while (itr.hasNext()){
                        System.out.print(itr.next() + " ");
                    }
                    System.out.println();


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}

package problems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Arpit on 14-Dec-15.
 */
public class TomAndJerry {
    public static void main(String[] args) {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t,n,m1,m2;
        try {
            t=Integer.parseInt(bufferedReader.readLine());
            while (t-->0){
                String s[]=bufferedReader.readLine().split("\\s");
                int sum=0;boolean ans=true;
                n=Integer.parseInt(s[0]);
                m1= Integer.parseInt(s[1]);
                m2= Integer.parseInt(s[2]);
                while(n>0){
                    if (m1>n&&m2>n){
                        if (ans)ans=false;
                        else ans=true;
                        break;
                    }
                    else if (m1==n || m2==n) break;
                    else{
                        if (m1>m2){
                            if (n-m1>0){
                                n-=m1;
                                if (ans)ans=false;
                                else ans=true;
                            }
                            else {
                                if (n-m2>0){
                                    n-=m2;
                                    if (ans)ans=false;
                                    else ans=true;
                                }
                                else break;
                            }
                        }
                        else{
                            if (n-m2>0){
                                n-=m2;
                                if (ans)ans=false;
                                else ans=true;
                            }
                            else{
                                if (n-m1>0){
                                    n-=m1;
                                    if (ans)ans=false;
                                    else ans=true;
                                }
                                else break;
                            }

                        }
                    }
                }
                if (ans) System.out.println(1);
                else System.out.println(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

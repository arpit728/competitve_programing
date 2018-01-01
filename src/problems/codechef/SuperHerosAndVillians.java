package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 31/12/16.
 */
public class SuperHerosAndVillians {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;

        t=Integer.parseInt(br.readLine());

        while (t-->0){

            n=Integer.parseInt(br.readLine());
            int sh=0,v=0;
            boolean draw=true,isSh=false,isV=false,flag=true;

            for (int i=0 ; i < n; i++) {
                String s=br.readLine();
                //s=s.substring(s.length()-3);
                int p=s.lastIndexOf("man");

                if (flag) {

                    if (p==-1)v++;
                    else if (s.length()-p==3) {
                        sh++;
                    }
                    else v++;

                    if (sh - v == 2) {
                        System.out.println("superheroes");
                        draw =flag= false;
                    }

                    if (v - sh == 3) {
                        System.out.println("villains");
                        draw = flag=false;
                    }
                }

            }
            if (draw)System.out.println("draw");

        }
    }
}

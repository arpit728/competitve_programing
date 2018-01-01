package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/8/2016.
 */
public class ChefAndColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        char s[];
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().toCharArray();
            int r,g,b;
            r=0;g=0;b=0;
            for (int i = 0; i < n; i++) {
                switch (s[i]){
                    case 'R':
                        r++;
                        break;
                    case 'G':
                        g++;
                        break;
                    case 'B':
                        b++;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(n-max(r,g,b));
        }
    }

    private static int max(int r, int g, int b) {
        return (r>=b && r>=g?r:((b>=g && b>=r)?b:g));
    }
}

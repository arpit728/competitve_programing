package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 2/20/2017.
 */
public class Chairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[]ch;
        int t=Integer.parseInt(br.readLine()),n;
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            ch=br.readLine().toCharArray();
            System.out.println(solve(ch,n));
        }
    }

    private static int solve(char[] ch,int n) {

/*
        System.out.println(Arrays.toString(ch));
*/
        //maxLength represents the maximum length of segment of zero
        int maxLength=0,cnt=0,start,end,empty=0;

        int i = 0,j = n-1;

        //count no of zeros in start
        for (; i <n ; i++) {
            if (ch[i]=='0'){
                cnt++;
                empty++;
            }
            else break;
        }
/*
        System.out.println(cnt+" "+empty);
*/
        //count no. of zeros in end
        for (; j>=0 ; j--) {
            if (ch[j]=='0'){
                empty++;
                cnt++;
            }
            else break;
        }
/*
        System.out.println(cnt+" "+empty);
*/

        maxLength=cnt;
        cnt=0;
        start=i;
        end=j;
        for (int k = start; k<=end ; k++) {

            if (ch[k/**/]=='0'){
                cnt++;
                empty++;
            }
            else {
                maxLength=Integer.max(cnt,maxLength);
                cnt=0;
            }
/*
            System.out.println(cnt);
*/
        }

/*
        System.out.println("maxLength = "+maxLength+" empty = "+empty);
*/

        return empty-maxLength;
    }
}

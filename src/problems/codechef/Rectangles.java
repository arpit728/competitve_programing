package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/28/2016.
 */
public class Rectangles {
    public static void main(String[] args) throws IOException {

        FastReader1 in=FastReader1.SYSTEM_READER;
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=in.nextInt();
        int l1,w1,l2,w2;
        long max,min=0,area1,area2;
        String s[];
        while (t-->0){
           /* s=br.readLine().split("\\s");
            l1=Integer.parseInt(s[0]);
            w1=Integer.parseInt(s[1]);
            l2=Integer.parseInt(s[2]);
            w2=Integer.parseInt(s[3]);*/

            l1=in.nextInt();
            w1=in.nextInt();
            l2=in.nextInt();
            w2=in.nextInt();

            area1=l1*w1;
            area2=l2*w2;
            max=area1+area2;

            if (l1==l2&& w1==w2){
                min=l1*w1;
            }
            else if (l1==l2 ){
                if (w1==w2)min=l1*w1;
                else if (w1>w2)min=l2*w2;
                else min=max-(l1*w1);
            }

            else {
                area1=l1*w1;
                area2=l2*w2;
                max=area1+area2;

                if (l1>l2  ) {

                    if (w1 >= w2) min = area1;

                    else if (w1<w2) min = max - (w1 * l2);
                }

                else if (l1<l2){

                    if (w1>w2)min=max-(l1*w2);

                    else if (w1<=w2)min=area2;

                    else min=max-(l1*w2);

                }


            }
            System.out.println(min+" "+max);

        }

    }
}

final class FastReader1 {

    public static final FastReader1 SYSTEM_READER = new FastReader1(System.in);
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int pos, count;

    public FastReader1(InputStream in) {
        this.in = in;
        pos = count = 0;
    }

    public int nextInt() {
        int c;
        while ((c = read()) < '0');
        int result = c - '0';
        while ((c = read() - '0') >= 0)
            result = 10 * result + c;
        return result;
    }
    private void fillBuffer() {
        try {
            count = in.read(buffer, pos = 0, buffer.length);
        } catch (Exception e) {
        }
    }

    public int read() {
        if (pos == count)
            fillBuffer();
        return buffer[pos++];
    }
}

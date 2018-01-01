package problems.codechef;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Arpit on 24-Dec-15.
 */
public class StupidProblem {

    InputStream is;
    PrintWriter out;
    String INPUT = "";
    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    void solve(){
        int m,n,dp[][],sp[],ans;
        n=ni();
        m=ni();
        dp=new int[n+1][m+1];
        sp=na(n);
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k=0;k<=min(j,sp[i-1]);k++)
                    dp[i][j]+=dp[i-1][j-k];
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        out.println(dp[n][m]);

    }

    void run() throws Exception
    {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }

    public static void main(String[] args) throws Exception {
        new StupidProblem().run();
    }

    int min(int a,int b){
        return a<b?a:b;
    }

    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }


}

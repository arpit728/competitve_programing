package facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by arpit on 7/1/17.
 */
public class ProgressPie {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,x,y,p;
        String[] s;
        t=Integer.parseInt(br.readLine());

        for (int i = 1; i <=t ; i++) {

            s=br.readLine().split("\\s");
            p=Integer.parseInt(s[0]);
            x=Integer.parseInt(s[1]);
            y=Integer.parseInt(s[2]);
            System.out.println("Case #"+i+": "+solve(p,x,y));

        }
    }

    private static String solve(int p, int x, int y) {
        x-=50;
        y-=50;

        int tempX=Math.abs(x),tempY=Math.abs(y);
        if (Math.sqrt(tempX*tempX+tempY*tempY)>50)return "white";
        double filledArea=3.6*p,theta;

        theta=Math.toDegrees(Math.atan2(x,y));

        if (x<=0 && y<=0)theta+=360;
        if (x<=0 && y>=0)theta+=360;

        if (theta>=0 && theta<=filledArea)return "black";

        return "white";
    }
}

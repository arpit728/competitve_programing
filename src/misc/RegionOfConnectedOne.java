package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 12/2/2016.
 */
public class RegionOfConnectedOne {

    static boolean vis[][],a[][];
    static int row,col,count;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s[];
        row=Integer.parseInt(br.readLine());
        col=Integer.parseInt(br.readLine());

        a=new boolean[row][col];
        vis=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            s=br.readLine().split("\\s");
            for (int j = 0; j < col; j++) {
                if (s[j].equals("1"))
                    a[i][j]=true;
            }
        }
        System.out.println(solve(a,row,col));

    }

    private static int solve(boolean[][] a, int row, int col) {


        return findMaxRegion(a,row,col);
    }

    private static int findMaxRegion(boolean[][] a, int row, int col) {

        int res=0;

        for (int i = 0; i < row; i++) {

            for(int j = 0; j < col; j++) {

                if(!vis[i][j] && a[i][j]){

                    //This program finds the no. region of connected one and also the greatest region.

                    //To find no. of region of connected one.
                    /*res++;
                    dfs(a,i,j);
*/
                    //To find biggest region of connected one uncomment the below code and comment he above two lines.

                    count=0;
                    dfs(a,i,j);
                    System.out.println(count);
                    res=Integer.max(res,count);
                }

            }
        }
        return res;
    }

    private static void dfs(boolean[][] a, int i, int j) {

        if ((i>=0 && i<row) &&(j>=0 && j<col))
        {

            if (!vis[i][j] && a[i][j]) {
                count++;
                vis[i][j]=true;

                dfs(a, i - 1, j);
                dfs(a, i - 1, j + 1);
                dfs(a, i, j + 1);
                dfs(a, i + 1, j + 1);
                dfs(a, i + 1, j);
                dfs(a, i + 1, j - 1);
                dfs(a, i, j - 1);
                dfs(a, i - 1, j - 1);
            }
            vis[i][j]=true;
        }

    }
}

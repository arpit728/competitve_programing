package misc;

/**
 * Created by arpit on 29/12/16.
 */
public class BiggestPlus {

    public static void main(String[] args) {

        int a[][]={{0,1,1},{1,1,1},{0,1,1}};

        System.out.println(solve(a,3,3));
    }

    private static int solve(int[][] a, int n, int m) {
        int ans=0;

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {

                if (a[i][j]==1 && a[i][j-1]==1&& a[i][j+1]==1 && a[i-1][j]==1  && a[i+1][j]==1){

                    int l,r,t,b,temp;
                    l=leftDfs(a,i,j-1,n,m);
                    r=rightDfs(a, i, j+1,n,m);
                    t=topDfs(a, i-1, j,n,m);
                    b=bottomDfs(a, i+1, j,n,m);
                    temp=Integer.min(Integer.min(l,Integer.min(r,t)),b);
                    ans=Integer.max(ans,temp);
                }
            }
        }
        return ans;
    }

    private static int leftDfs(int[][] a, int i, int j,int n,int m) {

        int cnt=0;
        while (j>=0 && a[i][j--]==1)cnt++;
        return cnt;
    }

    private static int rightDfs(int[][] a, int i, int j,int n,int m) {
        int cnt=0;
        while (j<m && a[i][j++]==1)cnt++;
        return cnt;
    }

    private static int topDfs(int[][] a, int i, int j,int n,int m) {
        int cnt=0;
        while (i>=0 && a[i--][j]==1)cnt++;
        return cnt;
    }

    private static int bottomDfs(int[][] a, int i, int j,int n,int m) {
        int cnt=0;
        while (i<n && a[i++][j]==1)cnt++;
        return cnt;
    }
}

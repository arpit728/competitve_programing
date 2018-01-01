package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arpit on 14/12/16.
 */
public class CountSimplePath {

    static boolean vis[]=new boolean[8];
    static int count=0;
    public static void main(String[] args) {
        int adj[][]=new int[][]{{0,1,1,1,0,0,0,0},
                {1,0,0,0,1,0,0,0},
                {1,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,1,0},
                {0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,0,1},
                {0,0,0,1,0,0,0,1},
                {0,0,0,0,1,1,1,0}};

        //In parameters zero represents source and 7 represents destination.
        dfsCountPath(adj, 0, 7);
        System.out.println(count);
        Arrays.fill(vis,false);
        System.out.println(checkPath(adj,0,7));
    }

    //This function checks whether there exists simple path between source s and destination d
    private static boolean checkPath(int[][] adj, int s, int d){

        vis[s]=true;

        if (s==d)return true;

        for (int i = 0; i < adj.length; i++)
            if (adj[s][i] == 1 && !vis[i]){
                return checkPath(adj, i, d);
            }

        return false;
    }

    //This dfs function calculates all the paths available from source s to destination d
    private static void dfsCountPath(int[][] adj, int s, int d) {

        vis[s]=true;
        if (s==d){
            vis[s]=false;//setting s/d to false again so that it could be discovered again for all paths
            count++;
            return;
        }
        for (int i = 0; i < adj.length; i++)
            if (adj[s][i] == 1 && !vis[i])
                dfsCountPath(adj, i, d);
    }
}

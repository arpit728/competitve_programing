package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by arpit on 29/1/16.
 */
public class DigJump {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char ch[] = br.readLine().toCharArray();
            ArrayList<Integer> adj[] = new ArrayList[10];
            boolean visited[] = new boolean[ch.length];
            int d[] = new int[ch.length], n = ch.length;
            Queue<Integer> q = new LinkedList<>();

            Arrays.fill(d, Integer.MAX_VALUE);
            for (int i = 0; i < 10; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                adj[ch[i] - '0'].add(i);
            }
            q.add(0);
            d[0] = 0;
            visited[0] = true;
            int u, v, sz, val;

            while (!q.isEmpty()) {

                u = q.poll();
                if (u==n-1)break;
                val = ch[u] - '0';
                sz = adj[val].size();

                for (int i = 0; i < sz; i++) {

                    v = adj[val].get(i);

                    if (!visited[v]) {
                        q.add(v);
                        d[v] = d[u] + 1;
                        visited[v] = true;
                    }
                }
                adj[val].clear();

                if (((u - 1) >= 0) && (!visited[u - 1])) {

                    q.add(u - 1);

                   d[u - 1] = d[u] + 1;

                    visited[u - 1] = true;
                }
                if (((u + 1) < n) && (!visited[u + 1])) {

                    q.add(u + 1);

                    d[u + 1] = d[u] + 1;

                    visited[u + 1] = true;
                }

            }
            System.out.println(d[ch.length - 1]);
    }
}

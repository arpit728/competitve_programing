package hiringchallenges;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


class StudiousAmitAndHisNewCollege {

    static boolean vis[]=new boolean[100000];
    static ArrayList<Integer> adjacencyList[]=new ArrayList[100000];
    static boolean recursionStack[]=new boolean[100000];

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    CustomInput input=new CustomInput();
                    int t=input.nextInt(),n,m;
                    for (int i = 0; i < 100000; i++) {
                        adjacencyList[i]=new ArrayList<>();
                    }
                    while (t-->0){
                        n=input.nextInt();
                        m=input.nextInt();
                        for (int i = 0; i < n; i++) {
                            adjacencyList[i].clear();
                        }
                        Arrays.fill(vis,0,n,false);
                        Arrays.fill(recursionStack,0,n,false);
                        for (int i = 0; i < m; i++) {
                            int u=input.nextInt()-1;
                            int v=input.nextInt()-1;
                            adjacencyList[u].add(v);
                        }

                        System.out.println(solve(n));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (StackOverflowError e) {
                    System.out.println("RTE");
                }
            }
        }, "1", 1 << 26).start();
    }

    private static int solve( int n) {
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (hasCycle(i)){
                    return 0;
                }
            }
        }
        return 1;
    }

    private static boolean hasCycle(int u) {
        recursionStack[u]=true;
        vis[u]=true;
        for (int i = 0; i < adjacencyList[u].size(); i++) {
            int v= adjacencyList[u].get(i);

            if (recursionStack[v]){
                return true;
            }
            if (!vis[v] && hasCycle(v))
                return true;
        }
        recursionStack[u]=false;
        return false;
    }

    static class CustomInput {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public CustomInput()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public CustomInput(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}


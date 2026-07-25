import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.Math.*;

public class Birthday {

    static long[] primes = new long[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73 };
    static final long MOD = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // Problem terminates when P = 0 and C = 0
            if (n == 0 && m == 0) break;

            solve(n, m);
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static void solve(int n, int m) throws IOException {
        List<int[]> edges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            edges.add(new int[]{u, v});
        }

        // 1. Initial check: Is the graph connected to begin with?
        if (countVisitedNodes(n, adj, -1, -1) < n) {
            pw.println("Yes");
            return;
        }

        // 2. Try removing each edge one by one
        boolean hasBridge = false;
        for (int[] edge : edges) {
            int skipU = edge[0];
            int skipV = edge[1];

            // If ignoring this edge reaches < n nodes, it's a bridge!
            if (countVisitedNodes(n, adj, skipU, skipV) < n) {
                hasBridge = true;
                break;
            }
        }

        if (hasBridge) {
            pw.println("Yes");
        } else {
            pw.println("No");
        }
    }

    // Helper BFS that skips a designated edge (skipU <-> skipV)
    private static int countVisitedNodes(int n, List<List<Integer>> adj, int skipU, int skipV) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(0);
        vis[0] = true;
        int visitedCount = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                // Skip the removed edge in both directions
                if ((u == skipU && v == skipV) || (u == skipV && v == skipU)) {
                    continue;
                }

                if (!vis[v]) {
                    vis[v] = true;
                    visitedCount++;
                    q.offer(v);
                }
            }
        }

        return visitedCount;
    }
}
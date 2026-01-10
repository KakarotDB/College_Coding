import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GraphTheoryEdgeWeights {
    static int M = (int) 1e5 + 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //vertices
        int m = Integer.parseInt(st.nextToken()); //edges
        double k = Double.parseDouble(st.nextToken());
        List<Integer>[] adj = new ArrayList[M]; //M - maximum vertices
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] u = new int[M];
        int[] v = new int[M];
        int[] apples = new int[n + 1];
        boolean[] picked = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }
        double[] time = new double[M];

        for (int e = 1; e <= m; e++) {
            st = new StringTokenizer(br.readLine());
            u[e] = Integer.parseInt(st.nextToken());
            v[e] = Integer.parseInt(st.nextToken());
            time[e] = Double.parseDouble(st.nextToken());
            adj[u[e]].add(e);
            adj[v[e]].add(e);
        }
        //at each step we can traverse the shortest edge whose apples we haven't picked yet until
        //time runs out, or we reach a vertex whose neighboring apples have been all taken
        //sorting all edges based on their time
        for (int i = 1; i < n + 1; i++) {
            adj[i].sort(Comparator.comparingDouble(e -> time[e]));
        }

        int curr = 1; //starting from vertex 1
        int score = 0; //number of apples picked
        while (k > 0) {
            picked[curr] = true;
            score += apples[curr];
            boolean should_we_go = false;
            int next_vertex = -1;
            for(int e : adj[curr]) {
                int next = u[e] ^ v[e] ^ curr;
                if (picked[next]) continue;
                if (time[e] > k) break;
                should_we_go = true;
                next_vertex = next;
                k -= time[e];
                break;
            }
            if (!should_we_go) break;
            curr = next_vertex;
        }
        //this is not an optimal solution but just a solution to see how things work
        System.out.println(score);
    }
}

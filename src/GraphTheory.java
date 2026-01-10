import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GraphTheory {
    //let's take input as :
    //n m, number of vertices, number of edges
    //following m lines have two numbers, showing the numbers connected by an edge
    //let's say there is a maximum of 1e5 + 5 number of vertices
    static int M = (int) 1e5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        int maxDegree = 0;
        int minDegree = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            if (!adj[i].isEmpty()) {
                System.out.println(i + ": " + Arrays.toString(adj[i].toArray()) );
                System.out.println("Degree of vertex " + i + ": " + adj[i].size());
                maxDegree = Math.max(adj[i].size(), maxDegree);
                minDegree = Math.min(adj[i].size(), minDegree);
            }
        }
        System.out.println("maxDegree = " + maxDegree);
        System.out.println("minDegree = " + minDegree);
    }
}

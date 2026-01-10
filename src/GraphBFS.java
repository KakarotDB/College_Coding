import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GraphBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            adj[u].add(V);
            adj[V].add(u);
        }
        for (int i = 1; i < v + 1; i++) {
            System.out.println(i + ":" + Arrays.toString(adj[i].toArray()));
        }
        /*
        To find all vertices of some vertex at distance 1, it's just the neighbours, so
        all the elements present in the list at adj[v], for v belonging to vertex set
        So on, and so forth, without checking the node we've already checked
         */
        System.out.println("BFS: ");

        int start = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[v + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Integer next : adj[vertex]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    /*
                    This BFS goes from left to right essentially
                     */
                }
            }
        }

    }
    public static void DFS_Using_Recursion(int v, boolean[] visited, List<Integer>[] adj) {
        if (visited[v]) return;
        visited[v] = true;
        System.out.print(v + " ");
        for(int next : adj[v]) {
            DFS_Using_Recursion(next, visited, adj);
        }
    }
    public static void DFS_Using_Stack(int v, boolean[] visited, List<Integer>[] adj) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node]) continue;
            visited[node] = true;

            System.out.print(node + " ");

            for(int next : adj[node]) {
                if (!visited[next]) stack.push(next);
            }
        }
    }
}

import java.io.*;
import java.lang.*;
import java.util.*;

public class GraphAssignment1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        pw.println("Graph Toolkit — choose an option:");
        pw.println("1. Check if a graph is Bipartite");
        pw.println("2. Check if two graphs are Isomorphic");
        pw.println("3. Generate DFS Spanning Tree");
        pw.println("4. Generate BFS Spanning Tree");
        pw.println("5. Exit");
        pw.print("Enter choice: ");
        pw.flush();

        int choice = Integer.parseInt(br.readLine().trim());

        switch (choice) {
            case 1: {
                System.out.println("Enter graph (n m, then m edges):");
                List<List<Integer>> adj = readGraph(br);
                boolean flag = isBipartite(adj);
                pw.println("Is Bipartite: " + flag);
                break;
            }

            case 2: {
                System.out.println("Enter FIRST graph (n m, then m edges):");
                List<List<Integer>> adj1 = readGraph(br);

                System.out.println("Enter SECOND graph (n m, then m edges):");
                List<List<Integer>> adj2 = readGraph(br);

                boolean result = areIsmorphic(adj1, adj2);
                pw.println("Are Isomorphic: " + result);
                break;
            }

            case 3: {
                System.out.println("Enter graph (n m, then m edges):");
                List<List<Integer>> adj = readGraph(br);
                List<List<Integer>> stAdj = getSpanningTree(adj);
                printAdjList(pw, stAdj, "DFS Spanning Tree");
                break;
            }

            case 4: {
                System.out.println("Enter graph (n m, then m edges):");
                List<List<Integer>> adj = readGraph(br);
                List<List<Integer>> stAdj = getSpanningTreeBFS(adj);
                printAdjList(pw, stAdj, "BFS Spanning Tree");
                break;
            }

            case 5:
                pw.println("Exiting.");
                break;

            default:
                pw.println("Invalid choice.");
        }

        pw.flush();
        pw.close();
    }

    //helper: reads "n m" followed by m edges, builds an adjacency list.
    private static List<List<Integer>> readGraph(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

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
        }

        return adj;
    }

    //Small helper: prints an adjacency list in a readable "u -> v1 v2 ..." format.
    private static void printAdjList(PrintWriter pw, List<List<Integer>> adj, String label) {
        pw.println(label + ":");
        for (int i = 0; i < adj.size(); i++) {
            pw.print(i + " -> ");
            for (int v : adj.get(i)) {
                pw.print(v + " ");
            }
            pw.println();
        }
    }

    //Q4: Writing a function to automate the process of finding whether a given graph is bipartite or not
    public static boolean isBipartite(List<List<Integer>> adj) {
        int[] color = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if(color[i] == 0) if(!dfs(adj, color, i, 1)) return false; 
        }

        return true;
    }

    //helper DFS function for bipartite check
    public static boolean dfs(List<List<Integer>> adj, int[] color, int u, int c) {
        color[u] = c;

        for(int v : adj.get(u)) {
            if(color[v] == 0) {
                if(!dfs(adj, color, v, -c)) return false;
            }
            else if(color[v] == c) return false;
        }

        return true;
    }

    //Q8: Checking if two graphs are isomorphic through recursion and backtracking, along with initial conditions
    public static boolean areIsmorphic(List<List<Integer>> adj1, List<List<Integer>> adj2) {
        int n1 = adj1.size();
        int n2= adj2.size();

        if(n1 != n2) return false;

        int sumOfDegreesAdj1 = 0, sumOfDegreesAdj2 = 0;

        int[] deg1 = new int[n1];
        int[] deg2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            deg1[i] = adj1.get(i).size();
            sumOfDegreesAdj1 += deg1[i];
        }

        for (int i = 0; i < n2; i++) {
            deg2[i] = adj2.get(i).size();
            sumOfDegreesAdj2 += deg2[i];
        }

        if(sumOfDegreesAdj1 != sumOfDegreesAdj2) return false; 

        Arrays.sort(deg1);
        Arrays.sort(deg2);

        if(!Arrays.equals(deg1, deg2)) return false;

        boolean[][] matrix1 = buildAdjMatrix(adj1);
        boolean[][] matrix2 = buildAdjMatrix(adj2);

        int[] mapping = new int[n1];
        Arrays.fill(mapping, -1);
        boolean[] usedInG2 = new boolean[n2];

        return backTrack(0, n1, mapping, usedInG2, adj1, adj2, matrix1, matrix2);
    }

    public static boolean backTrack(int u, int n, int[] mapping, boolean[] usedInG2, List<List<Integer>> adj1, List<List<Integer>> adj2, boolean[][] m1, boolean[][] m2) {
        if (u == n) {
            return true; //found a valid bijection
        }

        int degU = adj1.get(u).size();

        for(int v = 0; v < n; v++) {
            //vertex in g2 already mapped 
            if(usedInG2[v]) continue;
            
            //degrees must match 
            if(adj2.get(v).size() != degU) continue;

            //checking edge preservation with previously mapped neighbours 
            if(isValidMapping(u, v, mapping, m1, m2)) {
                mapping[u] = v;
                usedInG2[v] = true;
                if (backTrack(u + 1, n, mapping, usedInG2, adj1, adj2, m1, m2)) {
                    return true;
                }

                mapping[u] = -1;
                usedInG2[v] = false;
            }
        } 

        return false;
    }

    public static boolean isValidMapping(int u, int v, int[] mapping, boolean[][] m1, boolean[][] m2) {
        for (int i = 0; i < u; i++) {
            int mappedNeighbour = mapping[i];
            if (m1[u][i] != m2[v][mappedNeighbour]) {
                return false; // edge exists in g1 between (u, i) iff edge exists in g2 between (v, mappedneighbor)
            }
        }

        return true;
    }

    public static boolean[][] buildAdjMatrix(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for(int v : adj.get(i)) matrix[i][v] = true;
        }

        return matrix;

    }

    //Q10: Implementing DFS and producing spanning tree for simple graph
    public static List<List<Integer>> getSpanningTree(List<List<Integer>> adj) {
        int n = adj.size();
        List<List<Integer>> stAdj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            stAdj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) dfsSpanningTree(adj, stAdj, visited, i);
        }

        return stAdj;
    }

    public static void dfsSpanningTree(List<List<Integer>> adj, List<List<Integer>> stAdj, boolean[] visited, int u) {
        visited[u] = true;

        for(int v : adj.get(u)) {
            if(!visited[v]) {
                stAdj.get(u).add(v);    
                stAdj.get(v).add(u);    

                dfsSpanningTree(adj, stAdj, visited, v);
            }
        }
    }

    //Q11: Using BFS and producing spanning tree formed by BFS 
    public static List<List<Integer>> getSpanningTreeBFS(List<List<Integer>> adj) {
        int n = adj.size();
        List<List<Integer>> stAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stAdj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfsSpanningTree(adj, stAdj, visited, i);
            }
        }

        return stAdj;
    }

    public static void bfsSpanningTree(List<List<Integer>> adj, List<List<Integer>> stAdj, boolean[] visited, int u) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(u);

        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int v : adj.get(curr)) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.offer(v);

                    stAdj.get(curr).add(v);
                    stAdj.get(v).add(curr);
                }
            }
        }
    }
}
//  B. Merging the Sets

import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean check = false;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Map<Integer, ArrayList<Integer>> num_appears = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int li  = Integer.parseInt(st.nextToken());
                for (int j = 0; j < li; j++) {
                    int si = Integer.parseInt(st.nextToken());
                    num_appears.computeIfAbsent(si, k -> new ArrayList<>()).add(i);
                }
            }
            boolean all = true;
            Set<Integer> uniqueSets = new HashSet<>();
            for (int i = 1; i <= m; i++) {
                if (!num_appears.containsKey(i)) {
                    all = false;
                    break;
                }
                if (num_appears.get(i).size() == 1) {
                    uniqueSets.add(num_appears.get(i).getFirst());
                }
            }
            int opt = n - uniqueSets.size();

            if (all && opt >= 2)
                pw.println("YES");
            else
                pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
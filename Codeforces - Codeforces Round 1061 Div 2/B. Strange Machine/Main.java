//  B. Strange Machine

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
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int[] queries = new int[q];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++) {
                queries[i] = Integer.parseInt(st.nextToken());
            }
            int count_b = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B')
                    count_b++;
            }
            if (count_b == 0) {
                for (int i = 0; i < q; i++) {
                    pw.println(queries[i]);
                }
                continue;
            }

            int[] ja = new int[n];
            int[] jsteps = new int[n];
            int[] jnextpos = new int[n];

            for (int i = 0; i < n; i++) {
                int na = 0;
                int steps = 0;

                int p = i;

                while(s.charAt(p) == 'A') {
                    p = (p + 1) % n;
                    na++;
                    steps++;
                }

                steps++;

                ja[i] = na;
                jsteps[i] = steps;
                jnextpos[i] = (p + 1 ) % n;
            }

            for (int i = 0; i < q; i++) {
                int a = queries[i];
                int ans = 0;
                int curpos = 0;

                while(a >= 0) {
                    int na = ja[curpos];
                    int steps = jsteps[curpos];
                    int nextPos = jnextpos[curpos];

                    if (a <= na) {
                        ans += a; 
                        break;
                    }

                    a -= na;

                    a /= 2;

                    ans += steps;

                    curpos = nextPos;
                }
                pw.println(ans);
            }

        }
        pw.flush();
        pw.close();
        br.close();
    }
}
//  B. Pseudo Palindrome

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
            int d = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            boolean possible = true;
            Arrays.sort(a);
            if (n % 2 == 0) {
                for (int i = 1; i < n; i+=2) {
                    if (a[i] - a[i - 1] > d) {
                        possible = false;
                        break;
                    }
                }
            } else {
                possible = false;
                List<Long> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        list.add(a[j]);
                    }
                    boolean current_removal = true;
                    for (int j = 1; j < n - 1; j+=2) {
                        if (list.get(j) - list.get(j - 1) > d){
                            current_removal = false;
                            break;
                        }
                    }
                    if (current_removal) {
                        possible = true;
                        break;
                    }
                }
            }
            if (possible) pw.println("YES");
            else pw.println("NO");
        }
        pw.flush();
        pw.close();
        br.close();
    }

}


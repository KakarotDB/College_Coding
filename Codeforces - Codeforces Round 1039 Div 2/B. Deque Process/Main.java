//  B. Deque Process

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> p = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p.add(Integer.parseInt(st.nextToken()));
            }
            boolean smol = true;
            while (!p.isEmpty()) {
                if (smol) {
                    if (p.peekFirst() < p.peekLast()){
                        pw.print("L");
                        p.removeFirst();
                    }
                    else { 
                        pw.print("R");
                        p.removeLast();
                    }
                }
                else {
                    if (p.peekFirst() > p.peekLast()) {
                        pw.print("L");
                        p.removeFirst();
                    }
                    else {
                        pw.print("R");
                        p.removeLast();
                    }
                }
                smol = !smol;
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
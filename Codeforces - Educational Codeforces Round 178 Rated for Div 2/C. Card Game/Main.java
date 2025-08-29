//  C. Card Game

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
            String s = br.readLine();
            ArrayList<Integer> alice = new ArrayList<>();
            ArrayList<Integer> bob = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A') alice.add(i + 1);
                else bob.add(i + 1);
            }
            int largestA = alice.getLast();
            int smallestA = alice.getFirst();
            int largestB = bob.getLast();
            int smallestB = bob.getFirst();
            if (largestA == n && smallestA == 1)
                pw.println("Alice");
            else if (largestB == n && smallestB == 1)
                pw.println("Bob");
            else if (bob.size() == 1 && alice.size() == 1) {
                if (smallestA == 1)
                    pw.println("Alice");
                else
                    pw.println("Bob");
            } else if (smallestA == 1 && largestB == n) {
                if (bob.size() != 1)
                    pw.println("Bob");
                else
                    pw.println("Alice");
            } else if (smallestB == 1 && largestA == n) {
                if (alice.size() == 1)
                    pw.println("Bob");
                else {
                    int e = alice.get(alice.size() - 2);
                    if (e > largestB) pw.println("Alice");
                    else pw.println("Bob");
                }
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }
}
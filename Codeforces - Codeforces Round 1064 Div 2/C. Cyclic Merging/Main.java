// C. Cyclic Merging

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    static class Node implements Comparable<Node> {
        long value;
        Node prev, next;
        boolean merged;
        Node(long value) {
            this.value = value;
            this.merged = false;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.value, other.value);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[n];
            PriorityQueue<Node> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(Long.parseLong(st.nextToken()));
            }

            for (int i = 0; i < n; i++) {
                nodes[i].next = nodes[(i + 1) % n];
                nodes[i].prev = nodes[(i + n - 1) % n];
                pq.add(nodes[i]);
            }
            long totalCost = 0;
            long mergeDone = 0;

            while (mergeDone < n - 1) {
                Node minNode = pq.poll();
                if (minNode.merged) {
                    continue;
                }
                Node left = minNode.prev;
                Node right = minNode.next;
                Node smollNeighbour;
                if (left.value <= right.value) smollNeighbour = left;
                else smollNeighbour = right;
                long cost = max(minNode.value, smollNeighbour.value);
                totalCost+=cost;
                smollNeighbour.value = cost;
                left.next = right;
                right.prev = left;
                minNode.merged = true;
                mergeDone++;
            }
            pw.println(totalCost);
//            Collections.sort(a);

        }
        pw.flush();
        pw.close();
        br.close();
    }

    public static long gcd(long a, long b) {
        if (a == 0 && b == 0)
            return 0;
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void printArray(Object array, PrintWriter pw) {
        if (array.getClass().isArray()) {
            int n = Array.getLength(array);
            for (int i = 0; i < n; i++) {
                pw.print(Array.get(array, i) + " ");
            }
            pw.println();
        } else if (array instanceof Collection<?>) {
            for (Object o : (Collection<?>) array) {
                pw.print(o + " ");
            }
            pw.println();
        } else
            return;
    }

    public static class Pair implements Comparable<Pair> {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object)
                return true;
            if (!(object instanceof Pair pair))
                return false;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Pair other) {
            return Long.compare(this.x, other.x);
        }
    }
}
// E. The Robotic Rush

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer("");
        int t = Integer.parseInt(br.readLine());
        /* 
        Note
        If there is some cyclic shifts with a string s:
        s += s can help in simplifying the problem  
        */
        test:
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            /*
            What do we have?
            An infinitely long number line
            There are n robots, m spikes
            ith robot -> ai position on number line
            ith spike -> bi position on number line

            for each i, we have to output how many robots are alive after first i instructions

            Rephrase :
                Output the number of robots alive after processing all the instructions upto
                current instruction

            Left -> decrease position by 1 for all robots
            Right -> Increase position by 1 for all robots

            The relative position of the robots never change as they move synchronously

            So, we could store a list of robots that die if displacement reaches -x, or +x

            So, we can try building two lists of leftEvents and rightEvents such that they store
            what all robots try when they reach distance x
            dead[] array to keep track which robot has already died
            Iterate through the instructions, updating current displacement D
            if D new minimum -> trigger all left events
            else trigger all right events for new maximum

             */

            List<Long> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Long.parseLong(st.nextToken()));
            }

            List<Long> b = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b.add(Long.parseLong(st.nextToken()));
            }

            String instructions = br.readLine();

            Collections.sort(b);
            List<Integer>[] leftEvents = new ArrayList[k + 1];//leftEvents[i] holds a list of robots that would die if they move 5 units left
            List<Integer>[] rightEvents = new ArrayList[k + 1];

            for (int i = 0; i < n; i++) {
                long pos = a.get(i);
                int idx = Collections.binarySearch(b, pos);
                int insertion = -idx - 1;
                if (insertion < m) {
                    long distance = b.get(insertion) - pos;
                    if (distance <= k) {
                        if (rightEvents[(int) distance] == null) rightEvents[(int) distance] = new ArrayList<>();
                        rightEvents[(int) distance].add(i); //ith robot dies when it reaches this distance
                    }
                }
                if (insertion > 0) {
                    long distance = abs(b.get(insertion - 1) - pos);

                    if (distance <= k) {
                        int dist = (int) distance;
                        if (leftEvents[dist] == null) leftEvents[dist] = new ArrayList<>();
                        leftEvents[dist].add(i);
                    }
                }
                //now we have got Lists for each distance, which robots die at which distance
                //So we have pre-calculated and predicted the deaths for all distances
                //Now we have to simulate it
            }

            boolean[] dead = new boolean[n];
            int alive = n;
            int currentDisplacement = 0;
            int minimumDisplacement = 0;
            int maximumDisplacement = 0;

            for (int i = 0; i < k; i++) {
                char move = instructions.charAt(i);

                if (move == 'L') {
                    currentDisplacement--;

                    if (currentDisplacement < minimumDisplacement) {
                        minimumDisplacement = currentDisplacement;

                        int distance = -minimumDisplacement; //positive distance

                        if (distance <= k && leftEvents[distance] != null) {
                            for(int robotId : leftEvents[distance]) {
                                if (!dead[robotId]) {
                                    dead[robotId] = true;
                                    alive--;
                                }
                            }
                        }

                    }
                } else {
                    currentDisplacement++;
                    if (currentDisplacement > maximumDisplacement) {
                        maximumDisplacement = currentDisplacement;
                        int dist = maximumDisplacement;

                        if (dist <= k && rightEvents[dist] != null) {
                            for(int robotId : rightEvents[dist]) {
                                if (!dead[robotId]) {
                                    dead[robotId] = true;
                                    alive--;
                                }
                            }
                        }
                    }
                }
                pw.print(alive + " ");
            }

            pw.println();

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

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n < 4)
            return true;
        if ((n & 1) == 0)
            return false;
        for (int i = 3; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        if (array == null || array.length <= 1) return true;

        for (int i = 0; i < array.length - 1; i++) {
            // compareTo returns > 0 if array[i] is greater than array[i+1]
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        if (list == null || list.size() <= 1) return true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(char[] array) {
        if (array == null || array.length <= 1) return true;

        for (int i = 0; i < array.length - 1; i++) {
            // Primitives use standard comparison operators
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
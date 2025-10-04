//  D. Replace with Occurrences

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] b = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }
            long distinct_count = Arrays.stream(b).distinct().count();
            Map<Long, Long> frequency_Map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                frequency_Map.put(b[i], frequency_Map.getOrDefault(b[i], 0L) + 1);
            }
            boolean possible = true;
            for (Map.Entry<Long, Long> longLongEntry : frequency_Map.entrySet()) {
                long val = longLongEntry.getKey();
                long count = longLongEntry.getValue();
                if (count % val != 0) {
                    possible = false;
                    break;
                }
            }
            if (!possible)
                pw.println(-1);
            else {
                long[] a = new long[n];
                Integer[] indices = new Integer[n];
                for (int i = 0; i < n; i++) {
                    indices[i] = i;
                }

                Arrays.sort(indices, Comparator.comparingLong(i -> b[i]));

                long currentAVal = 0;
                int i = 0;
                while (i < n) {
                    long groupSize = b[indices[i]];
                    currentAVal++;

                    for (int j = 0; j < groupSize; j++) {
                        a[indices[i + j]] = currentAVal;
                    }
                    i += groupSize;
                }

                for (long l : a) {
                    pw.print(l + " ");
                }
                pw.println();
            }

        }
        pw.flush();
        pw.close();
        br.close();

    }
}
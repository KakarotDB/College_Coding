//  B. Olya and Game with Arrays

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
            ArrayList<Long> secondElements = new ArrayList<>();
            long lowest_first_element = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                long[] a = new long[m];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[j] = Long.parseLong(st.nextToken());
                }
                Arrays.sort(a);
                secondElements.add(a[1]);
                lowest_first_element = min(lowest_first_element, a[0]);
            }
            Collections.sort(secondElements);
            long sum_of_second_elements = secondElements.stream().mapToLong(Long::longValue).sum();
            long lowest_second_minimum = secondElements.getFirst();
            long answer = lowest_first_element + sum_of_second_elements - lowest_second_minimum;
            pw.println(answer);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}
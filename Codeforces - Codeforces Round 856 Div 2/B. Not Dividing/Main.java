//  B. Not Dividing

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            long[] array = new long[n];
            int number_of_operations_left = 2*n;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = Long.parseLong(st.nextToken());
                if (array[i] == 1) {
                    array[i]++;
                    number_of_operations_left--;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (array[i+1] % array[i] == 0 && number_of_operations_left>= 0)
                {
                    array[i+1]++;
                    number_of_operations_left--;
                }
            }
            for (int i = 0; i < n; i++) {
                pw.print(array[i] + " ");
            }
            pw.println();



        }
        pw.flush();
        pw.close();
        br.close();

    }
}
//  Permutations

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        if (n == 1)
            pw.println(1);
        else {
            if (n<=3)
                pw.println("NO SOLUTION");
            else {
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    array[i] = i+1;
                }
                for (int i = 0; i < n; i++) {
                    if (array[i] % 2 == 0)
                        pw.print(array[i]+ " ");
                }
                for (int i = 0; i < n; i++) {
                    if (array[i] % 2 == 1)
                        pw.print(array[i] + " ");
                }
                pw.println();


            }
        }
        pw.close();

    }
}
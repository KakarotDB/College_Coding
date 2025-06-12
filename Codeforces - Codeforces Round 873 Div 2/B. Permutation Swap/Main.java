//  B. Permutation Swap

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            int[] permutation = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());

            }
            int g = abs(permutation[0] - 1);
            for (int i = 0; i < n; i++) {
                g = gcd(g, abs(permutation[i] - (i+1)));
            }
            System.out.println(g);


        }
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
//  B. Longest Divisors Interval

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0)
        {
            long n = Long.parseLong(br.readLine());
            long i = 1;
            while (n % i == 0) i++;
            System.out.println(i-1);
        }
    }
}
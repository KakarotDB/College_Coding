//  A. Make It Zero

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            br.readLine();
            if (n % 2 == 0)
            {
                System.out.println(2);
                System.out.println(1+ " " +n);
                System.out.println(1+ " " +n);
            }
            else
            {
                System.out.println(4);
                System.out.println(1+ " " +n);
                System.out.println(1+ " " + (n-1));
                System.out.println((n-1) + " " + (n));
                System.out.println((n-1) + " " + (n));
            }

        }

    }
}
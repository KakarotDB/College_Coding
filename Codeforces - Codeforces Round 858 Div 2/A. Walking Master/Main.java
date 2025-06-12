//  A. Walking Master

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();
            if (d<b)
                System.out.println(-1);
            else
            {
                long move1 = d-b;
                a = a+move1;
                long move2 = a-c;
                if (move2 < 0)
                    System.out.println("-1");
                else
                    System.out.println(move1+move2);
            }
        }

    }
}
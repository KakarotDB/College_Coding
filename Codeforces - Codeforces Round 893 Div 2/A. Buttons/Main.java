//  A. Buttons

import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            if (a>b)
                System.out.println("First");
            else if (b>a) {
                System.out.println("Second");
            }
            else
            {
                if (c%2 == 0)
                    System.out.println("Second");
                else
                    System.out.println("First");
            }
        }

    }
}
//  A. Energy Crystals

import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            long x = sc.nextLong();
            if (x==0)
                System.out.println("0");
            else {
                int numberOfBits = Long.toBinaryString(x).length();
                System.out.println(2L * numberOfBits + 1);
            }
        }
    }
}
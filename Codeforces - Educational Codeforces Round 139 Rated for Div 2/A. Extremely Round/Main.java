//  A. Extremely Round

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Long> extremely_round = new ArrayList<>();
        for(int i = 1; i<= 999999 ; i++)
        {
            if (check(i))
                extremely_round.add((long)i);
        }

        while (t-->0)
        {
//            int n = sc.nextInt();
            long n = sc.nextLong();
            long count = 0;
            for (int i = 0; i < extremely_round.size(); i++) {
                if (extremely_round.get(i) <= n)
                    count++;
                else
                    break;
            }
            System.out.println(count);
        }
    }
    public static boolean check(long x)
    {
        long count_of_digits = 0;
        long count_of_zeroes = 0;
        while (x!=0)
        {
            if (x % 10 == 0)
                count_of_zeroes++;
            count_of_digits++;
            x/=10;
        }
        return count_of_zeroes == count_of_digits-1;
    }
}
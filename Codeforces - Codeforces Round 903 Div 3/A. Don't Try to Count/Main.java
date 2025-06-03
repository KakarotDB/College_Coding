//  A. Don't Try to Count

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            StringBuilder x = new StringBuilder(sc.next());
            String s = sc.next();
            int number_of_operations = 0;

            while ( number_of_operations <= 6)
            {
                if (x.toString().contains(s))
                {
//                    System.out.println(number_of_operations);
                    break;
                }
                x.append(x);
                number_of_operations++;


            }
            if (number_of_operations >= 6)
                System.out.println("-1");
            else
                System.out.println(number_of_operations);







        }

    }
}
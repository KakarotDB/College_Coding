//  C. Prepend and Append

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            String binary = sc.next();
            int start = 0, end = n-1;
            int count =n;
            if (n == 1)
                System.out.println(1);
            else {
                while (start < end) {
                    if (binary.charAt(start) != binary.charAt(end))
                        count -= 2;
                    else
                        break;
                    start++;
                    end--;
                }
                System.out.println(count);
            }

        }

    }
}
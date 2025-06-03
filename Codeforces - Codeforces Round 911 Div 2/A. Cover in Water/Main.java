//  A. Cover in Water

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
            StringBuilder cells = new StringBuilder(sc.next());
            int count_Blocked = 0;
            int count_Empty_Continuous = 0;
            int max_count = 0;
            for (int i = 0; i < cells.length(); i++) {
                if (cells.charAt(i) == '#') {
                    count_Empty_Continuous = 0;
                    count_Blocked++;
                }
                else
                {
                    count_Empty_Continuous++;
                    max_count = Math.max(max_count, count_Empty_Continuous);
                }
                if (max_count==3)
                    break;

            }
            if (count_Blocked == n)
            {
                System.out.println("0");
                continue;
            }
            if (max_count >=3){
                System.out.println("2");
                continue;
            }
            else{
                System.out.println(n-count_Blocked);
            }




        }

    }
}
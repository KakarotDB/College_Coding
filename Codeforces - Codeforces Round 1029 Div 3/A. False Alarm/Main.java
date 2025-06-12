//  A. False Alarm

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int first_index = list.indexOf(1);
            int last_index = list.lastIndexOf(1);
            if (x>= last_index - first_index + 1)
                System.out.println("YES");
            else
                System.out.println("NO");


        }
    }
}
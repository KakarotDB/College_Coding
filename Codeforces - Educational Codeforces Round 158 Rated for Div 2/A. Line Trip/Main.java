//  A. Line Trip

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            list.add(x);
            int current_Distance = 0, max_Distance = 0;
            for (int i = 0; i < n + 1; i++) {
                if (i==n){
                    max_Distance = Math.max(max_Distance, 2*(list.get(i+1)-list.get(i)));
                }
                else
                    max_Distance = Math.max(max_Distance, list.get(i+1) - list.get(i));
            }
            System.out.println(max_Distance);
        }
    }
}
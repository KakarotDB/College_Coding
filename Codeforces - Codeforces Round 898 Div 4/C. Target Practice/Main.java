//  C. Target Practice

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int[][] score = {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
                    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
                    {1, 2, 3, 4, 5, 5, 4, 3, 2, 1},
                    {1, 2, 3, 4, 4, 4, 4, 3, 2, 1},
                    {1, 2, 3, 3, 3, 3, 3, 3, 2, 1},
                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            int sum = 0;
            char[][] board = new char[10][10];
            for (int i = 0; i < 10; i++) {
                String line = sc.next();
                for (int j = 0; j < 10; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == 'X')
                        sum+=score[i][j];

                }
            }
            System.out.println(sum);


        }

    }
}
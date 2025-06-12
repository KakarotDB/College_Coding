//  A. One and Two

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int number_of_2s_beforei = 0;
                int number_of_2s_afteri = 0;
                for (int j = 0; j <= i; j++) {
                    if (array[j] == 2)
                        number_of_2s_beforei++;
                }
                for(int j = i+1 ; j < n ; j++)
                {
                    if (array[j] == 2)
                        number_of_2s_afteri++;
                }
                if (number_of_2s_beforei == number_of_2s_afteri)
                {
                    System.out.println(i+1);
                    break;
                }
                if (i== n-1 && !(number_of_2s_afteri == number_of_2s_beforei))
                    System.out.println(-1);
            }

        }

    }
}
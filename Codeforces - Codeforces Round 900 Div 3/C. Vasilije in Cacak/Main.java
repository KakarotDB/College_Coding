//  C. Vasilije in Cacak

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long minimum_Possible_Sum = (k * (k + 1))/2;
            long maximum_Possible_Sum = (n * (n + 1))/2 - ((n-k)*(n-k+1))/2;
            if (x>=minimum_Possible_Sum && x<= maximum_Possible_Sum)
                System.out.println("YES");
            else
                System.out.println("NO");


        }

    }
}
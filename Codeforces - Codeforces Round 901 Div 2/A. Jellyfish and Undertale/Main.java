//  A. Jellyfish and Undertale

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long[] tools = new long[(int)n];
            st = new StringTokenizer(br.readLine());
            long answer = b;
            for (int i = 0; i < n; i++) {
                tools[i] = Long.parseLong(st.nextToken());
                answer += min(tools[i], a-1);
            }
            System.out.println(answer);


        }

    }
}
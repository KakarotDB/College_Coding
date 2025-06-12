//  D. Balanced Round

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<Long> difficulties = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                difficulties.add(Long.parseLong(st.nextToken()));
            }
            int current_Length = 0;
            int maximum_length = 0;
            Collections.sort(difficulties);
            for (int i = 0; i < difficulties.size()-1; i++) {
                if (difficulties.get(i+1) - difficulties.get(i) <= k)
                {
                    current_Length++;
                    maximum_length = max(maximum_length, current_Length);
                }
                else
                    current_Length = 0;
            }
            pw.println(n-maximum_length-1);

        }
        pw.close();
    }
}
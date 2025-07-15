import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int minVal = a[0];
            int maxVal = a[0];
            for (int i = 1; i < n; i++) {
                minVal = Math.min(minVal, a[i]);
                maxVal = Math.max(maxVal, a[i]);
            }

            int[] pMinL = new int[n];
            int[] sMaxR = new int[n];
            StringBuilder ans = new StringBuilder();
            pMinL[0] = a[0];
            sMaxR[n - 1] = a[n - 1];
            for (int i = 1; i < n; i++) {
                pMinL[i] = min(pMinL[i - 1], a[i]);
            }
            for(int i = n - 2; i >= 0; i--) {
                sMaxR[i] = max(sMaxR[i + 1], a[i]);
            }
            for (int i = 0; i < n; i++) {
                if (a[i] == pMinL[i] || a[i] == sMaxR[i])
                    ans.append('1');
                else
                    ans.append('0');
            }
            System.out.println(ans);
        }
    }
}

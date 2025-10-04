//  E. Mexification

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int mex = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != i) {
                    mex = i;
                    break;
                }
            }
            if (k == 1) {
                a = updateArray(a, n);
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i];
                }
                pw.println(sum);
                continue;
            }
            a = updateArray(a, n);
            a = updateArray(a, n);
            if (k % 2 == 0) {
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i];
                }
                pw.println(sum);
            }
            else {
                a = updateArray(a, n);
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i];
                }
                pw.println(sum);
            }
        }
        pw.flush();
        pw.close();
        br.close();

    }
    public static int[] updateArray(int[] a, int n){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        int mex = 0;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)){
                mex = i;
                break;
            }
        }
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
        }
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (fmap.get(a[i]) > 1 || mex < a[i])
                newArr[i] = mex;
            else
                newArr[i] = a[i];
        }
        return newArr;
    }
}
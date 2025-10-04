//  E. Mexification

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.*;

public class TESTING_SHIT_OUT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            Map<Integer, Integer> fmap = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                set.add(a[i]);
            }
            int mex = 0;
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                if (!set.contains(i)){
                    mex = i;
                    break;
                }
            }
            Arrays.sort(a);
            if (mex < a[n - 1]) {
                for (int i = 0; i < n; i++) {
                    if (a[i] > mex)
                        a[i] = mex;
                    fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
                }
                if (k % 2 == 1) {
                    for (int i = 0; i < n; i++) {
                        sum += a[i];
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        if (a[i] == mex && fmap.get(a[i]) != 1) a[i] ++;
                        sum += a[i];
                    }
                }

            }
            else {
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    fmap.put(a[i], fmap.getOrDefault(a[i], 0) + 1);
                }
                for (int i = 0; i < n; i++) {
                    if (fmap.get(a[i]) > 1) flag = false;
                }
                if (flag) {
                    for (int i = 0; i < n; i++) {
                        sum += a[i];
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        if (fmap.get(a[i]) > 1) a[i] = mex;
                    }
                    if (k == 1) {
                        for (int i = 0; i < n; i++) {
                            sum += a[i];
                        }
                    }
                    else {
                        for (int i = 0; i < n; i++) {
                            if (a[i] != i) {
                                mex = i;
                                break;
                            }
                        }
                        for (int i = 0; i < n; i++) {
                            if (a[i] > mex)
                                a[i] = mex;
                        }
                        if (k % 2 == 0) {
                            for (int i = 0; i < n; i++) {
                                sum += a[i];
                            }
                        }
                        else {
                            for (int i = 0; i < n; i++) {
                                if (a[i] == mex) a[i]++;
                                sum += a[i];
                            }
                        }
                    }
                }
            }

            pw.println(sum);
        }
        pw.flush();
        pw.close();
        br.close();

    }
}
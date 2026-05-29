import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class DZhilyAndBarknights {
    static final long MOD = 998244353;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st;
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            solve();
        }
        pw.flush();
        pw.close();
    }

    public static void solve() throws IOException {
        String line = br.readLine();
        while (line != null && line.isEmpty()) line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());
        
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
        
        long[] b = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) b[i] = Long.parseLong(st.nextToken());

        int sizeA = n * (n - 1) / 2;
        int sizeB = n * (n - 1);
        
        long[] A = new long[sizeA];
        long[] B = new long[sizeB];

        int idxA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                A[idxA++] = (a[i] << 32) | (a[j] & 0xFFFFFFFFL);
            }
        }

        int idxB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                B[idxB++] = (b[j] << 32) | (b[i] & 0xFFFFFFFFL);
            }
        }

        quickSort(A, 0, sizeA - 1);
        quickSort(B, 0, sizeB - 1);

        long totalInversions = 0;
        int ptrB = 0;
        for (int i = 0; i < sizeA; i++) {
            long nA = A[i] >>> 32, dA = A[i] & 0xFFFFFFFFL;
            while (ptrB < sizeB) {
                long nB = B[ptrB] >>> 32, dB = B[ptrB] & 0xFFFFFFFFL;
                if (nB * dA < nA * dB) ptrB++;
                else break;
            }
            totalInversions = (totalInversions + ptrB) % MOD;
        }

        long totalPerm = (long) n * (n - 1) % MOD;
        long expectedValue = (totalInversions * power(totalPerm, MOD - 2)) % MOD;
        pw.println(expectedValue);
    }

    static void quickSort(long[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        long pivot = arr[left + rnd.nextInt(right - left + 1)];
        long pN = pivot >>> 32, pD = pivot & 0xFFFFFFFFL;

        while (i <= j) {
            while (true) {
                long cur = arr[i];
                long cN = cur >>> 32, cD = cur & 0xFFFFFFFFL;
                if (cN * pD < pN * cD) i++;
                else break;
            }
            while (true) {
                long cur = arr[j];
                long cN = cur >>> 32, cD = cur & 0xFFFFFFFFL;
                if (cN * pD > pN * cD) j--;
                else break;
            }
            if (i <= j) {
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, i, right);
    }

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
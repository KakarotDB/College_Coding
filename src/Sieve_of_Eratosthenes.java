import java.sql.SQLOutput;
import java.util.*;
//finds primes in O(n log log n) time
public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> prime = new ArrayList<>();
        prime = sieve(n);
        System.out.println(Arrays.toString(prime.toArray()));
    }
    public static List<Integer> sieve(int n) {
            if (n < 2) {
                return new ArrayList<>();
            }

            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, 2, n + 1, true);

            for (int p = 2; p * p <= n; p++) {
                if (isPrime[p]) {
                    for (int i = p * p; i <= n; i += p) {
                        isPrime[i] = false;
                    }
                }
            }

            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
            }
            return primes;
    }

}

import java.sql.SQLOutput;
import java.util.*;

//finds primes in O(n log log n) time
public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> prime = new ArrayList<>();
        prime = sieve(n);
//        System.out.println(Arrays.toString(prime.toArray()));
        int[] prefix_sum = new int[prime.size()];
        prefix_sum[0] = prime.getFirst();
        for (int i = 1; i < prime.size(); i++)
            prefix_sum[i] = prefix_sum[i - 1] + prime.get(i);
        for (int i : prefix_sum) {
            if (isPrime(i)) System.out.print(i + " ");
        }

    }
     public static boolean isPrime(int n) {
             if (n < 2)
                 return false;
             if (n < 4)
                 return true;
             if ((n & 1) == 0)
                 return false;
             for (int i = 3; i * i <= n; i++)
                 if (n % i == 0)
                     return false;
             return true;
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

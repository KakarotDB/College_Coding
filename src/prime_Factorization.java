import java.util.*;

public class prime_Factorization {
    public Map<Integer, Integer> getPrimeFactors(int n) {
        Map<Integer, Integer> primeFactors = new HashMap<>();

        if (n <= 1) {
            // Return an empty map for n <= 1
            return primeFactors;
        }

        // Factor out 2 and count its power
        while (n % 2 == 0) {
            primeFactors.put(2, primeFactors.getOrDefault(2, 0) + 1);
            n /= 2;
        }

        // Factor out odd numbers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) {
            primeFactors.put(n, primeFactors.getOrDefault(n, 0) + 1);
        }

        return primeFactors;
    }

    public static void main(String[] args) {
        prime_Factorization obj = new prime_Factorization();
        System.out.println(obj.getPrimeFactors(1));
        System.out.println(obj.getPrimeFactors(37));
        System.out.println(obj.getPrimeFactors(315));
    }
}

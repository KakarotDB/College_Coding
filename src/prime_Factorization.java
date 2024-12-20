import java.util.Arrays;

public class prime_Factorization {
    public boolean isPrime(int n)
    {
        if (n==1)
            return false;
        int number_of_factors = 0;
        for (int i = 1; i < n; i++) {
            if (n%i==0)
                number_of_factors++;
        }
        if (number_of_factors<=1)
            return true;
        else
            return false;
    }
    public void Prime_factors(int n)
    {
        if (isPrime(n)) {
            System.out.println("The given number is a prime number");
        }
        else if(n==1)
        {
            System.out.println("1 is not a prime number, and has only 1 factor");
        }
        else
        {
            String prime_factors = "";

            while (n % 2 == 0) {
                prime_factors += Integer.toString(2);
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    prime_factors += Integer.toString(i);
                    n /= i;
                }

            }
            if (n>2)
                prime_factors+=n;
            System.out.println(Arrays.toString(prime_factors.toCharArray()));
        }
    }

    public static void main(String[] args) {
        prime_Factorization obj = new prime_Factorization();
        obj.Prime_factors(1);
        obj.Prime_factors(37);
        obj.Prime_factors(315);
    }
}

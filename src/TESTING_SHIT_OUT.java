import java.util.Arrays;

public class TESTING_SHIT_OUT {
    public static void main(String[] args) {
        int n = 5;
        long[] memo = new long[n + 1];
        System.out.println(fibonacci_With_Memoization(n, memo));

    }
    public static boolean check_power_of_2(int n){
        int check = n & (n - 1);
        return check == 0;
    }
    public static long fibonacci_With_Memoization(int n, long[] memo) {
        long result = 0;
        if (memo[n] != 0)
            return memo[n];
        if (n == 1 || n == 2)
            result = 1;
        else
            result = fibonacci_With_Memoization(n - 1, memo) + fibonacci_With_Memoization(n - 2, memo);
        memo[n] = result;
        return result;
    }
}
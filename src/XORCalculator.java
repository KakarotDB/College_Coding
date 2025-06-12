import java.util.Arrays;
import java.util.Scanner;

public class XORCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers for operation : ");
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int xor = 0;
        for (int i = 0; i < numbers.length; i++) {
            xor^=numbers[i];
        }
        System.out.println("XOR operation result = " + xor);
    }
}

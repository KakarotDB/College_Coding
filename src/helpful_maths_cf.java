import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class helpful_maths_cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] numbers = input.split("\\+");
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i!=numbers.length-1)
                System.out.print(numbers[i]+"+");
            else
                System.out.print(numbers[i]);
        }

    }
}

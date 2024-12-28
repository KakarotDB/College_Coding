import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Horseshoe_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = (Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray());
        long count = Arrays.stream(array).distinct().count();
        long answer = 4-count;
        System.out.println(answer);
    }
}

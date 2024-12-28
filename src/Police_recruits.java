import java.util.Arrays;
import java.util.Scanner;

public class Police_recruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();



    }
}

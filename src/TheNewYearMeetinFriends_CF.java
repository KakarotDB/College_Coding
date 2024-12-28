import java.util.Arrays;
import java.util.Scanner;

public class TheNewYearMeetinFriends_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        System.out.println(array[2]-array[0]);
        System.out.println("Cock and balls ".repeat(2000));
    }
}

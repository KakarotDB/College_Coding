import java.util.Arrays;
import java.util.Scanner;

public class Pairs_In_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array : ");
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                System.out.print("(" +array[i] + "," + array[j]+ ") ");

            }

            System.out.println();

        }
    }
}

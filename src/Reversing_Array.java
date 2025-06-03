import java.util.Arrays;
import java.util.Scanner;

public class Reversing_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 0, end = array.length -1;
        System.out.println("Original array : " + Arrays.toString(array));
        while (start <= end)
        {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
        System.out.println("Reversed array : " + Arrays.toString(array));

    }
}

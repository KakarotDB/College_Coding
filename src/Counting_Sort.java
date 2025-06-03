import java.util.Arrays;
import java.util.Scanner;

public class Counting_Sort {
    public static void counting_Sort(int[] array)
    {
        int j = 0;
        int largest = Arrays.stream(array).max().getAsInt();
        int[] count_array = new int[largest+1];
        for (int i : array) count_array[i]++; //storing the frequency of each element in count array
        //sorting

        for (int i = 0; i < count_array.length; i++) {
            while (count_array[i] > 0)
            {
                array[j] = i;
                j++;
                count_array[i]--;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input_array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        counting_Sort(input_array);
        System.out.println("Sorted array : " + Arrays.toString(input_array));
    }
}

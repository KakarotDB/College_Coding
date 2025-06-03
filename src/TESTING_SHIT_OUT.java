import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TESTING_SHIT_OUT {
    public static void main(String[] args) {
//        int[] array = {5,4,3,2,1};
//        Bubble_Sort(array);
//        System.out.println("Sorted array : " + Arrays.toString(array));
        Scanner sc = new Scanner(System.in);
        System.out.println(4%3);
        
    }
    static void Bubble_Sort(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}

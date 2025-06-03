import java.util.Arrays;
import java.util.Scanner;

public class Selection_Sort {
    public static void selection_Sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int minimum_Position = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minimum_Position] > array[j])
                    minimum_Position = j;
            }
            int temp = array[i];
            array[i] = array[minimum_Position];
            array[minimum_Position] = temp;
            
        }
    }
    public static void main(String[] args) {
        int[] array = {3,4,2,1};
        selection_Sort(array);
        System.out.println(Arrays.toString(array));
    }
}

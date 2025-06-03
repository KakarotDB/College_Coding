import java.util.Arrays;

public class Insertion_Sort {
    public static void insertion_Sort(int[] array)
    {
        for (int i = 1; i < array.length ; i++) {
            //'i' is the current element
            int current_element = array[i];
            int previous = i-1;
            //following while loop helps in finding the correct position to insert
            while (previous >= 0 && (array[previous] > current_element))
            {
                array[previous+1] = array[previous];
                previous--;
            }
            //insertion
            array[previous+1] = current_element;
            
        }
    }

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        insertion_Sort(array);
        System.out.println(Arrays.toString(array));
    }
}

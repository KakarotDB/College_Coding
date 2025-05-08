import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        merge_Sort(array);
        System.out.println(Arrays.toString(array));

    }

    static void merge_Sort(int[] array){
        if (array.length<=1) return; //base case
        int middle_position = array.length/2;
        int[] leftArray = new int[middle_position];
        int[] rightArray = new int[array.length-middle_position];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < middle_position)
                leftArray[i] = array[i];
            else {
                rightArray[j] = array[i];
                j++;
            }
        }
        merge_Sort(leftArray);
        merge_Sort(rightArray);
        Merge(leftArray, rightArray, array);

    }

    private static void Merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;
        while (l < leftSize && r < rightSize)
        {
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
}

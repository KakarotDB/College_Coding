import java.util.Arrays;
import java.util.Random;

public class Sorting_Algorithms
{
    public static void BubbleSort(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j]>array[j+1])
                {
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    public void selection_Sort(int array[])
    {
        for (int i = 0; i < array.length-1; i++) {
            int min = i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[min]>array[j])
                {
                    min = j;
                }

            }
            int temp = array[i];
            array[i] = array[min];
            array[min]=temp;
            
        }
        System.out.print(Arrays.toString(array));
    }
    public void insertion_Sort(int array[])
    {
        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
             int j = i-1;
             while (j>=0 && array[j]>temp) {
                 array[j + 1] = array[j];
                 j--;
             }
             array[j+1]=temp;


        }
        System.out.println(Arrays.toString(array));
    }
    public static void counting_Sort(int array[])
    {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        int countArray [] = new int[max-min+1];
        for (int value : array)
        {
            countArray[value-min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < max-min+1; i++) {
            while (countArray[i]>0)
            {
                array[arrayIndex]= i+min;
                countArray[i]--;
                arrayIndex++;
            }

            
        }
    }

    public static void main(String[] args) {
        int n = (int)1e8;
        int k = (int) 1e3;
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(k + 1 );
        }
        long startTime = System.nanoTime();
        counting_Sort(array);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1e9);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }

}

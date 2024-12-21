import java.util.Arrays;

public class Sorting_Algorithms
{
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
    public void BubbleSort(int[] array)
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

}

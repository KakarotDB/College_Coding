public class Binary_Search {
    public static void main(String[] args) {
        int [] array = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        int search = 5;
        int searched_index = Binary_Search(array, search);
        if (searched_index == -1)
        {
            System.out.println("Element not found !");
            System.exit(0);
        }
        System.out.format("Found element at index %d", searched_index);
    }
    public static int Binary_Search(int[] array, int search)
    {
        if (search > array[array.length-1] || search < array[0])
            return 0;
        int left = 0, right = array.length-1, found;
        while (left <= right)
        {
            int middle = left + (right-left)/2;
            if (search > array[middle])
            {
                left = middle +1;

            }
            else if (search < array[middle]) {
               right = middle -1;
            }
            else if (search == array[middle])
                return found = middle;
        }
        return -1;



    }
}

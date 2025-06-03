import java.util.Arrays;

public class Sub_Arrays_Operations {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
//            print_SubArrays(arr);
        System.out.println("Maximum sub array sum using bruteforce method is : " + max_SubArray_bruteForce(arr));
        System.out.println("Maximum sub arary sum using Kadane's algorithm : " + max_SubArray_Kadanes_Algorithm(arr));
    }
    static void print_SubArrays(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            StringBuilder sub_array = new StringBuilder();
//            int temp[] = new int[array.length];
            for (int j = i; j < array.length; j++) {
//                temp[j] = array[j];
//                System.out.println(Arrays.toString(temp));

                sub_array.append(array[j]).append(" ");
                System.out.println(sub_array.toString().trim());
            }
        }
    }
    static int max_SubArray_bruteForce (int array[])
    {
        int best =0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum+=array[k];
                }
                best = Math.max(sum,best);
            }
        }
        return best;
    }
    static int max_SubArray_Kadanes_Algorithm(int array[])
    {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int j : array) {
            currentSum = Math.max(j, currentSum + j);
            maxSum = Math.max(currentSum, maxSum);

        }
        return maxSum;
    }

}

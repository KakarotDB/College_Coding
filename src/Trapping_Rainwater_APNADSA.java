import java.util.Arrays;
import java.util.Scanner;

public class Trapping_Rainwater_APNADSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*We are given to compute the total water area trapped, given n non-negative integers
        and width of each bar is 1
        So, water trapped = (water level - current level of bar)*width = (water level - current bar level)*1
        There are three cases where no water is trapped, as shown in the case handling
        To find the water level at a particular level/height, we take the minimum(leftMaxBoundary, RightMaxBoundary
        and apply the formula
        We take the help of auxiliary arrays to find the water level, by storing the leftMaxBoundary, and
        RightMaxBoundary for each element of the array.
         */
        int trapped_water = 0;
        int[] elevation_map = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max_elevation = Arrays.stream(elevation_map).max().getAsInt();
        if (elevation_map.length <=2 || (isAscending(elevation_map) || isDescending(elevation_map)))
        {
            System.out.println("Amount of water trapped : 0");
            System.exit(0);
        }
        int[] left_Maximum_Boundaries = new int[elevation_map.length]; //auxillary array to store the left maximum boundary of each element/height
        int[] right_Maximum_Boundaries = new int[elevation_map.length]; //Same as above but for right maximum boundary
        left_Maximum_Boundaries[0] = elevation_map[0];
        right_Maximum_Boundaries[elevation_map.length-1] = elevation_map[elevation_map.length-1];
        for(int i = 1; i < elevation_map.length ; i++)
        {
            left_Maximum_Boundaries[i] = Math.max(elevation_map[i], left_Maximum_Boundaries[i-1]);
        }
        for(int i = elevation_map.length-2 ; i>=0 ; i--)
        {
            right_Maximum_Boundaries[i] = Math.max(right_Maximum_Boundaries[i+1], elevation_map[i]);
        }
        for (int i = 0; i < elevation_map.length; i++) {
            int water_level = Math.min(left_Maximum_Boundaries[i], right_Maximum_Boundaries[i]);
            trapped_water = trapped_water + water_level - elevation_map[i];

        }
        System.out.println(trapped_water);
    }
    public static boolean isAscending(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1])
                return false;
        }
        return true;
    }
    public static boolean isDescending(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] < array[i+1])
                return false;
        }
        return true;
    }
}

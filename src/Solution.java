import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

class Solution {
    public int minSwaps(int[] nums) {
        int count_even = 0;
        int count_odd = 0;
        int n = nums.length;
        for(int i = 0; i < n ; i++){
            if(nums[i] % 2 == 0)
                count_even++;
            else
                count_odd++;
        }
        if (count_even - count_odd > 1)
            return -1;
        int swaps = 0;
        return 1;
    }
}

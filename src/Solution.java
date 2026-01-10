import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> fmap = new HashMap<>();
        int n = nums.length;
        for(int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : fmap.entrySet()) {
            int freq = integerIntegerEntry.getValue();
            int num = integerIntegerEntry.getKey();
            if (freq >= n / 3) ans.add(num);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
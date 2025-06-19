import java.util.HashSet;

public class LeetCode_MaxSubstringWithnoRepeats {
    public int lengthOfLongestSubstring(String s){
        HashSet<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left_pointer = 0;
        for (int right_pointer = 0; right_pointer < s.length(); right_pointer++) {
            while (seen.contains(s.charAt(right_pointer))){
                seen.remove(s.charAt(left_pointer));
                left_pointer++;
            }
            seen.add(s.charAt(right_pointer));
            maxLength = Math.max(maxLength, right_pointer - left_pointer + 1);
        }
        return maxLength;
    }
}

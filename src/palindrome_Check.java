

public class palindrome_Check {
    public boolean check_for_palindrome(String string)
    {
        int length = string.length();
        int left_pointer = 0;
        int right_pointer = length -1;
        while (left_pointer<right_pointer)
        {
            if (string.charAt(left_pointer)!=string.charAt(right_pointer))
                return false;
            left_pointer++;
            right_pointer--;
        }
        return true;
    }
    public static void main(String[] args) {
        palindrome_Check obj = new palindrome_Check();
        String example_palindrome = "racecar";
        System.out.println(obj.check_for_palindrome(example_palindrome));
        System.out.println(obj.check_for_palindrome("NotAPalindrome"));


    }
}

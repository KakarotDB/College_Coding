

public class palindrome_Check {
    public String reverse_String(String string)
    {
        int length = string.length(); // length of the string
        String reversed = "";
        for (int i = length-1; i >=0; i--) {
            reversed+=string.charAt(i); //we reverse the string by adding characters from the end of the string.

        }
        return reversed;
    }
    public boolean check_for_palindrome(String string)//checking for palindrome
    {
        palindrome_Check obj = new palindrome_Check();//creating object
        String reversed = obj.reverse_String(string);//reversing the string by calling previously defined method "reverse_String"
        if (string.compareToIgnoreCase(reversed)==0)//.compareToIgnoreCase() function returns 0 if both strings are identical, ignoring uppercase or lowercase.
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        palindrome_Check obj = new palindrome_Check();
        String example_palindrome = "racecar";
        System.out.println(obj.check_for_palindrome(example_palindrome));
        System.out.println(obj.check_for_palindrome("NotAPalindrome"));

    }
}

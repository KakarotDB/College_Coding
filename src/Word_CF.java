import java.util.Scanner;

public class Word_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int frequency_of_uppercase_characters=0;
        for (int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i)))
                frequency_of_uppercase_characters++;
        }
        if (frequency_of_uppercase_characters>(word.length()/2))
            System.out.println(word.toUpperCase());
        else
            System.out.println(word.toLowerCase());
    }
}

import java.util.Scanner;

public class WordCapitalization_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (Character.isUpperCase(input.charAt(0)))
            System.out.println(input);
        else
        {
            char upperCase = Character.toUpperCase(input.charAt(0));
            System.out.print(upperCase);
            for (int i = 1; i<input.length(); i++)
            {

                System.out.print(input.charAt(i));
            }
        }

    }
}

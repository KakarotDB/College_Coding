import java.util.Arrays;
import java.util.Scanner;

public class BoyOrGirl_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] character_of_input = input.split("");
        Arrays.sort(character_of_input);
        int counter = 0;
//        for (int i = 0; i < character_of_input.length; i++) {
//            System.out.print(character_of_input[i]+" ");
//        }
        String[] unique_characters = new String[character_of_input.length];
        for (int i = 0; i < character_of_input.length-1; i++) {
            if (character_of_input[i].equals(character_of_input[i+1]))
                continue;
            else
                counter++;
        }
        counter++;
        if (counter%2==0)
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
}

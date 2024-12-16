import java.util.Random;
import java.util.Scanner;
public class Gamerisms {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int random = rand.nextInt(100);
        int user_guess=0;
        int no_of_guesses = 0;
        while(user_guess!=random){
            System.out.print("Enter a number: ");
            user_guess = sc.nextInt();
            if(user_guess>random) {
                System.out.println("Too high");
                no_of_guesses++;
            }
            else if (user_guess < random) {
                System.out.println("Too low");
                no_of_guesses++;

            }
            else {
                System.out.println("Correct guess!");
                System.out.println("Total number of guesses : " +no_of_guesses);
                break;
            }
        }
    }
}

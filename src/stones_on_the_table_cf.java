import java.util.Scanner;

public class stones_on_the_table_cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        int counter = 0;
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i)==input.charAt(i+1))
                counter++;
        }
        System.out.println(counter);
    }
}

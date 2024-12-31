import java.util.Scanner;

public class HQ9plus_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.contains("Q") ||input.contains("H") ||input.contains("9") )
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

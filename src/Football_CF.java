import java.util.Scanner;

public class Football_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int counter = 1;
        System.out.println((input.contains("0000000") || input.contains("1111111")? "YES" : "NO"));
    }
}

import java.util.Scanner;

public class Pangram_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String word = sc.next().replaceAll("\\s+", "");
        long count = word.toLowerCase().chars().distinct().count();
        if (count == 26)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

import java.util.Scanner;

public class skibidusandAmogu_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            StringBuilder input = new StringBuilder(sc.next());
            input.setCharAt(input.length()-2, 'i');
            input.setCharAt(input.length()-1, ' ');
            System.out.println(input);
        }
    }
}

import java.util.Scanner;

public class Anton_and_Letters_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll(",", "").replaceAll(" ", "").replaceAll("\\{", "").replaceAll("}", "");
//        System.out.println(input);

        long count = input.chars().distinct().count();
        System.out.println(count);
    }
}

import java.util.OptionalInt;
import java.util.Scanner;

public class beautiful_Year_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (Integer.toString(++t).chars().distinct().count()<4)
        {}
        System.out.println(t);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Amusing_Joke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String guest = sc.next();
        String host = sc.next();
        String[] pile = sc.next().split("");
        Arrays.sort(pile);
        String pile_sorted = Arrays.toString(pile).replaceAll("\\s+", "")
                .replace("[", "")
                .replace("]", "");

        String[] guest_host = (guest+host).split("");
        Arrays.sort(guest_host);
        String checking = Arrays.toString(guest_host).replaceAll("\\s+", "")
                .replace("[", "").replace("]", "");
//        System.out.println("pile_sorted = " + pile_sorted);
//        System.out.println("checking = " + checking);
        if (checking.compareToIgnoreCase(pile_sorted)==0)
            System.out.println("YES");
        else
            System.out.println("NO");


    }
}

import java.util.Scanner;

public class CF_993_Div4B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String observed_from_outside = sc.next();
            String mirrored = "";
            for (int i = observed_from_outside.length() - 1; i >= 0; i--) {
                if (observed_from_outside.charAt(i) == 'q')
                    mirrored += 'p';
                else if (observed_from_outside.charAt(i) == 'p') {
                    mirrored += 'q';


                } else
                    mirrored += observed_from_outside.charAt(i);
            }
            System.out.println(mirrored);
            t--;
        }

    }
}

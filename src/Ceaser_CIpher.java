import java.util.Scanner;

public class Ceaser_CIpher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            String input = sc.next().toLowerCase();
            int k = sc.nextInt();
            StringBuilder ceaser_ciphered = new StringBuilder("");
            for (int i = 0; i < input.length() ; i++) {
                if(input.charAt(i)<=(char)('z'-k))
                    ceaser_ciphered.append((char)(input.charAt(i)+k));
                else
                    ceaser_ciphered.append((char)(input.charAt(i)-26+k));

            }
            System.out.println(ceaser_ciphered);
        }
    }
}

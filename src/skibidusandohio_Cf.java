import java.util.Scanner;

public class skibidusandohio_Cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            StringBuilder s = new StringBuilder(sc.next());
            int ans = s.length();
            for (int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i)==s.charAt(i+1))
                    ans = 1;

            }







            
            System.out.println(ans);

        }
    }
}

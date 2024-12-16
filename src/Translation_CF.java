import java.util.Scanner;

public class Translation_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        String reversed = "";
        for (int i = s.length()-1; i >=0; i--) {
            reversed+=s.charAt(i);
        }
        if (reversed.equalsIgnoreCase(t))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

import java.util.Scanner;

public class UltraFastMathematician_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String output = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)==b.charAt(i))
                output+='0';
            else
                output+='1';
            
        }
        System.out.println(output);
    }
}

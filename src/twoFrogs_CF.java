import java.util.Scanner;

public class twoFrogs_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            if (Math.abs(a-b)%2==0)
                System.out.println("Yes");
            else
                System.out.println("no");
        }


    }
}

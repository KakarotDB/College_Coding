import java.util.Scanner;
public class SmallPalindrome_CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int x = sc.nextInt(), y = sc.nextInt();
            if(x!=0 && y!=0)
                System.out.println("1".repeat(x/2) + "2".repeat(y) + "1".repeat(x/2));
            else if (x==0 && y!=0) {
                System.out.println("2".repeat(y));


            }
            else if (x!=0 && y==0)
                System.out.println("1".repeat(x));
        }
    }
}

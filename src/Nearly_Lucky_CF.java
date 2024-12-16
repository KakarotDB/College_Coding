import java.util.Scanner;

public class Nearly_Lucky_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int frequency= 0;
        while (n>0)
        {
            if(n%10 == 7 || n%10 ==4)
                frequency++;
            n/=10;
        }
        if (frequency == 4 || frequency == 7)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

import java.util.Scanner;

public class x2by6_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int count3 = 0;
            int count2 = 0;
            while (n%6==0)
            {
                n/=6;
                count2++;

            }
            while (n%3==0) {
                n/=3;
                count3++;

            }

//                count2++;
            if (n==1)
                System.out.println(2*count3+count2);
            else
                System.out.println("-1");
        }
    }
}

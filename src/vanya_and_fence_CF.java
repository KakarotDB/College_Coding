import java.util.Scanner;

public class vanya_and_fence_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int h = sc.nextInt();
        int width = 0;
        while (n-->0)
        {
            int height_of_friend = sc.nextInt();
            if (height_of_friend>h)
                width+=2;
            else
                width++;
        }
        System.out.println(width);

    }
}

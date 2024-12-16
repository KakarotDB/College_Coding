import java.util.Scanner;

public class game_of_division_Cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s,]+");
        int n = sc.nextInt();
        int k  = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n; j++) {
                int absolute_difference = Math.abs(array[i]-array[j]);
                if(absolute_difference%k!=0)
                {
                    System.out.println("YES\n"+i);
                    System.exit(0);
                }

            }
        }
        System.out.println("NO");
    }
}

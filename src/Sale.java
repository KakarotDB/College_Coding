import java.util.Arrays;
import java.util.Scanner;

public class Sale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).filter(s->s<0).toArray();
        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));

        if (m<=array.length) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += array[i];

            }
            System.out.println(Math.abs(sum));
        }
        else {
            int sum = 0;

            for (int i = 0; i < array.length; i++) {
                sum += array[i];

            }
            System.out.println(Math.abs(sum));

        }
    }
}

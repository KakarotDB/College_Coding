import java.util.Arrays;
import java.util.Scanner;

public class Twins_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long sum = Arrays.stream(array).sum();
//        System.out.println(sum);
        int tempsum = 0;
        int counter = 0;
        Arrays.sort(array);
        for (int i = n-1; i >= 0 ; i--) {
            tempsum+=array[i];
            counter++;
            if (tempsum>sum/2) {
                break;
            }

        }
        System.out.println(counter);

    }
}

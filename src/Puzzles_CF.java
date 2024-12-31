import java.util.Arrays;
import java.util.Scanner;

public class Puzzles_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(array);
        int minimum_difference = 1001;
//        int final_answer;
//        if (m<=4)
//        {
//            for (int i = 0; i < m-n+1; i++) {
//                minimum_difference = Math.min(minimum_difference, (array[i+n-1]-array[i]));
//
//            }
//        }
        for (int i = 0; i < m-n+1; i++) {
            minimum_difference = Math.min(minimum_difference, (array[i+n-1]-array[i]));

        }
        System.out.println(minimum_difference);

    }
}

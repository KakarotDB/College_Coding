import java.util.Arrays;
import java.util.Scanner;

public class kefaAndFirstSteps_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        int max_counter = 0;
        for (int i = 0; i < n-1; i++) {
            if (array[i]<=array[i+1]) {
                counter++;
                max_counter = Math.max(counter,max_counter);
            }
            else
                counter = 0;
            
        }
        System.out.println(++max_counter);
    }
}

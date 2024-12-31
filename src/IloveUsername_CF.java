import java.util.Arrays;
import java.util.Scanner;

public class IloveUsername_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        if (n==1)
        {
            System.out.println("0");
            System.exit(0);
        }
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(Arrays.toString(array));
        int amazing_performances = 0;
        int best_performance=array[0], worst_performance=array[0];
        for (int i = 1; i < n; i++) {
            if (array[i]>best_performance)
                {
                    amazing_performances++;
                    best_performance=array[i];
                }
            if (array[i]<worst_performance)
            {
                amazing_performances++;
                worst_performance = array[i];
            }
//            System.out.println("amazing_performances = " + amazing_performances);

        }
        System.out.println(amazing_performances);

    }
}

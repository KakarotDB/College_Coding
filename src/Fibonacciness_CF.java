import java.util.Arrays;
import java.util.Scanner;

public class Fibonacciness_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-->0)
        {

            int[] array = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] fibonnaciness_array = new int[3];
            fibonnaciness_array[0] = array[0]+array[1];
            fibonnaciness_array[1] = array[2]-array[1];
            fibonnaciness_array[2] = array[3]-array[2];
            long unique = Arrays.stream(fibonnaciness_array).distinct().count();
            if (unique==3)
                System.out.println("1");
            else if (unique==2) {
                System.out.println("2");

            }
            else
                System.out.println("3");


        }
    }
}

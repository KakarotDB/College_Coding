import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(array);
        System.out.println(Arrays.toString(array).replace("[", "")
                .replace("]", "")
                .replace("," ,""));


    }
}

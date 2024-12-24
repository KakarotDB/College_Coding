import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IwannaBeTheGUy_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        sc.next();
        String[] line_1 = sc.nextLine().split(" ");
//        System.out.println(Arrays.toString(line_1));
        sc.next();
        String[] line_2 = sc.nextLine().split(" ");
        String[] merged_array = Stream.concat(Arrays.stream(line_1), Arrays.stream(line_2)).toArray(String[]::new);
        long count = Arrays.stream(merged_array).filter(s->!s.isEmpty()).mapToInt(Integer::parseInt).filter(x->x>0).distinct().count();


        System.out.println((count==n)?"I become the guy." : "Oh, my keyboard!");



    }
}

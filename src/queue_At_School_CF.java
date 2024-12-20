import java.util.Arrays;
import java.util.Scanner;

public class queue_At_School_CF
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.next();
        int t = sc.nextInt();
        String queue = sc.next();
        while (t-->0)
            queue=queue.replaceAll("BG", "GB");
        System.out.println(queue);


    }
}

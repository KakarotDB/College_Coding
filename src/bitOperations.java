import java.util.Scanner;

public class bitOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(((15&(1<<i))==0)?"0":"1");
        System.out.println(10|(1<<i));
        System.out.println(10>>2);
    }
}

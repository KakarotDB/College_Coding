import java.util.Scanner;

public class GamesWithSticks_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int sum = sc.nextInt()+ sc.nextInt();
        System.out.println((Math.min(sc.nextInt(), sc.nextInt())%2)==0?"Malvika" : "Akshat");
    }
}

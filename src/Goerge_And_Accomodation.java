import java.util.Scanner;

public class Goerge_And_Accomodation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number_of_rooms_with_space = 0 ;
        while (n-->0)
        {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if ((q-p)>=2)
                number_of_rooms_with_space++;
        }
        System.out.println(number_of_rooms_with_space);
    }
}

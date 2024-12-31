import java.util.Arrays;
import java.util.Scanner;

public class Police_recruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a==-1 && m==0)
                counter++;
            else if (a==-1 && m!=0) {
                m--;
                
            }
            else
                m+=a;

        }
        System.out.println(counter);


    }
}

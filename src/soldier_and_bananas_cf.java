import java.util.Scanner;

public class soldier_and_bananas_cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        double n = sc.nextDouble();
        int w = sc.nextInt();
        double total_cost=0;
        for (int i = 1; i <=w; i++) {
            total_cost = total_cost+i*k;
        }
        double amount_need_to_borrow_from_friend = total_cost-n;
        if(amount_need_to_borrow_from_friend>0)
            System.out.println((int)amount_need_to_borrow_from_friend);
        else
            System.out.println("0");
    }
}

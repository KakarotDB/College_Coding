import java.util.Scanner;

public class NewYearAndHurry_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int time_left_for_problems = 240-k;
        int number_of_problems_solved = 0;
        int time_for_problems = 0;
        for (int i = 1; i <=n; i++)
        {
            if (time_for_problems>time_left_for_problems)
                break;
            else
            {
                time_for_problems+=i*5;
                number_of_problems_solved++;
            }

        }
        System.out.println((time_for_problems>time_left_for_problems)?(number_of_problems_solved-1):(number_of_problems_solved));
    }
}

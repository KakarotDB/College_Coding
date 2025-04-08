import java.util.Arrays;
import java.util.Scanner;

public class Jiangly_Vs_Tourist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] problem_ratings = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int touristScore = simulateContest(problem_ratings, 3892);
        int jianglyScore = simulateContest(problem_ratings, 3797);

        if (jianglyScore > touristScore) {
            System.out.println("Jiangly");
        } else if (touristScore > jianglyScore) {
            System.out.println("Tourist");
        } else {
            System.out.println("Draw");
        }
    }
    static int simulateContest(int[] problems, int initialRating)
    {
        int score = 0;
        int currentRating = initialRating;
        int i = 0;

        while (i < problems.length)
        {
            if (currentRating >= problems[i])
            {
                int newRating = currentRating ^ problems[i];
                score += newRating;
                currentRating = newRating;

                boolean found = false;
                for (int j = 1; j <= i+1; j++) {
                    if (gcd(i+1, j) != 1) {
                        i =i+j-1;
                        found = true;
                        break;
                    }
                }
                if (!found) break;
            } else {
                i++;
            }
        }
        return score;
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

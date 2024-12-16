import java.util.Scanner;
public class nextRound_cf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //sc.useDelimiter("[\\s,]+");
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        int counter=0, advancing = 0;
        for (int i = 0; i < n; i++) {
            scores[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if(scores[i]==0)
                counter++;
            else if (scores[i] >= scores[k - 1]) {
                advancing++;
                if (scores[i]==0)
                    advancing--;
            }
        }
        if(counter==n)
            System.out.println("0");
        else
            System.out.println(advancing);

    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Fox_and_Snake_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] pattern = new char[n][m];
        for (int i = 0; i < n; i++) {
            if (i%2==0)
            {
                for (int j = 0; j < m; j++) {
                    pattern[i][j] = '#';

                }
            }
            else if(i%2!=0)
            {
                int temp = (i + 1) / 2;
                if (temp % 2 != 0)
                {
                    pattern[i][m - 1] = '#';
                    for (int j = 0; j < m-1; j++) {
                        pattern[i][j] = '.';

                    }
                }
                else
                {
                    pattern[i][0] = '#';
                    for (int j = 1; j < m; j++) {
                        pattern[i][j] ='.';

                    }
                }
            }
            
        }
        for (char[] x : pattern)
            System.out.println(Arrays.toString(x).replace("[", "")
                    .replace("]", "").replace(", ", ""));
    }
}

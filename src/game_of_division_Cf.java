import java.util.Arrays;
import java.util.Scanner;

public class game_of_division_Cf {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int[] array = new int[n];
            int k =sc.nextInt();
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
//            System.out.println(Arrays.toString(array));
            int index = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0 ; j < n; j++) {
                    if(j==i)
                        continue;
                    int difference = Math.abs(array[i] - array[j]);
                    System.out.println(difference);
                    if (difference%k != 0) {
                        index = j+1;
                        break;
                    }


                }
                if (index!=-1)
                    break;
            }
            if (index != -1)
                System.out.println("Yes\n" + index);
            else
                System.out.println("no");
        }
    }
}

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
//this code only works if you're limited to only one operation per index.
public class skibidus_and_fanum_tax_easy_CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int trash = sc.nextInt();
            sc.nextLine();
            int[] array = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int m = sc.nextInt();
            if (n==1)
                System.out.println("yes");
            else
            {
                boolean sorted= true;
                for (int i = 0; i < n; i++) {
                    sorted = true;
                    int temp = array[i];
                    array[i]=m-array[i];
                    for (int j = 0; j < n-1; j++) {
                        if (array[j] > array[j+1]) {
                            array[i] = temp;
                            sorted = false;
                        }
                    }
                    if(sorted)
                        break;


                }
                if (sorted)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }


        }
    }
}

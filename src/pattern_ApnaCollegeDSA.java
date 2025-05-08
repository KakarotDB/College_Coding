import java.util.Scanner;

public class pattern_ApnaCollegeDSA {
    public static void main(String[] args) {
//        Hollow_Rectangle_Pattern(4,5);
        inverted_and_Rotated_Half_Pyramid(4);

    }
    public static void inverted_and_Rotated_Half_Pyramid(int rows)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void Hollow_Rectangle_Pattern(int length, int breadth)
    {
        for (int i = 0; i < length; i++) {
            if (i == 0 || i == length -1)
            {
                for (int j = 0; j < breadth; j++) {
                    System.out.print("*");
                }
            }
            else
            {
                for (int j = 0; j < breadth; j++) {
                    if (j == 0 || j == breadth -1)
                        System.out.print("*");
                    else
                        System.out.print(" ");

                }
            }
            System.out.print("\n");
        }

    }
}

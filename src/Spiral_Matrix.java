import java.util.Arrays;
import java.util.Scanner;

public class Spiral_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows and columns for matrix : ");
        int rows = sc.nextInt(); int columns = sc.nextInt();
        int[][] input_matrix = new int[rows][columns];
        System.out.println("Enter elements into the matrix : ");
        int startCol = 0, startRow = 0 , endCol = columns-1, endRow = rows-1;
        while (startRow <= endRow && startCol <= endCol)
        {
            //topBoundary
            for(int j = startCol; j <= endCol ; j++)
            {
                input_matrix[startRow][j] = sc.nextInt();
            }
            //rightBoundary
            for (int i = startRow+1; i <= endRow; i++) {
                input_matrix[i][endCol] = sc.nextInt();
            }
            //bottomBoundary
            for(int j = endCol-1 ; j >= startCol ; j--)
            {
                input_matrix[endRow][j] = sc.nextInt();
            }
            //leftBoundary
            for (int i = endRow-1; i >=startRow+1 ; i--) {
                input_matrix[i][startCol] = sc.nextInt();
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println("Spirally Inputted matrix : ");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(input_matrix[i]));
        }

    }
}

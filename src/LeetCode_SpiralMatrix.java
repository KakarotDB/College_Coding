import java.util.*;
public class LeetCode_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int startCol = 0, startRow = 0 , endCol = columns-1, endRow = rows-1;
        while (startRow <= endRow && startCol <= endCol) {
            //top Boundary
            for (int i = startCol; i <= endCol; i++) {
                spiral.add(matrix[startRow][i]);
            }
            //rightBoundary
            for (int i = startRow+1; i <= endRow; i++) {
                spiral.add(matrix[i][endCol]);
            }
            //bottomBoundary
            for(int j = endCol-1 ; j >= startCol ; j--)
            {
                spiral.add(matrix[endRow][j]);
//                input_matrix[endRow][j] = sc.nextInt();
            }
            //leftBoundary
            for (int i = endRow-1; i >=startRow+1 ; i--) {
                spiral.add(matrix[i][startCol]);
//                input_matrix[i][startCol] = sc.nextInt();
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return spiral;
    }
}

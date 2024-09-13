import java.util.ArrayList;

public class MatrixExampleTester {
    public static void main(String[] args) {
        System.out.println("Matrix Multiplication works: " + testMultiplyMatricies());
        System.out.println("Matrix Generation works: " + testGenerateMatricies());
    }


 /*
  * tests if matrix multiplication is working by comparing results
  * to kown matrix multiplication equation results
  */
    private static boolean testMultiplyMatricies() {

        int[][] A1 = {
                {1, 8, 3},
                {8, 4, 5},
                {6, 2, 7}
        };

        int[][] B1 = {
                {6, 7, 4},
                {1,3,2},
                {5, 9, 8}
        };

        int[][] result1 = {
               {29, 58, 44},
               {83, 120, 84},
                {73, 111, 84}
        };

        int[][] A2 = {
               {1, 5, 4},
               {9, 3, 8}
        };

        int[][] B2 = {
                {6, 7},
                {1, 3},
                {5, 9}
        };

        int[][] result2 = {
                {31, 58},
                {97, 144}
        };


        int[][] A3 = {
                {2, 0, -3},
                {1, 4, 5}
        };

        int[][] B3 = {
                {3, 1},
                {-1, 0},
                {4, 2}
        };

        int[][] result3 = {
                {-6, -4},
                {19, 11}
        };

        int[][] matrix1 = MatrixExample.multiplyMatrices(A1, B1);
        int[][] matrix2 = MatrixExample.multiplyMatrices(A2, B2);
        int[][] matrix3 = MatrixExample.multiplyMatrices(A3, B3);
        // printMatrix(matrix1);
        // System.out.println();
        // printMatrix(matrix2);
        // System.out.println();
        // printMatrix(matrix3);
        

        if (!matriciesAreTheSame(matrix1, result1) || !matriciesAreTheSame(matrix2, result2) || !matriciesAreTheSame(matrix3, result3))
            return false;
        return true;
    }

    private static void printMatrix (int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Returns true if the generator creates the correct length
     * matricies, and if each matrix is unique
     * tests 10 matricies to ensure that this is true
     */
    private static boolean testGenerateMatricies() {
        ArrayList<int[][]> matricies = new ArrayList<>();
        int rows = (int) (Math.random() * 10 + 1);
        int cols = (int) (Math.random() * 10 + 1);
        for (int i = 0; i < 10; i++) {
            int[][] matrix = MatrixExample.generateRandomMatrix(rows, cols);
            if (matrix.length != rows || matrix[0].length != cols)
                return false;
            for (int[][] other : matricies) {
                if (matriciesAreTheSame(other, matrix))
                    return false;
            }
            matricies.add(matrix);
        }
        return true;
    }

    // Returns true if two matricies are identical
    private static boolean matriciesAreTheSame(int[][] one, int[][] two) {
        if (one.length != two.length || one[0].length != two[0].length)
            return false;
        for (int r = 0; r < one.length; r++) {
            for (int c = 0; c < one[0].length; c++) {
                if (one[r][c] != two[r][c])
                    return false;
            }
        }
        return true;
    }
}
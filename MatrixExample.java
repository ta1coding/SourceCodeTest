import java.util.Random;

public class MatrixExample {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5, 6 },
                { 4, 5, 6, 3, 7, 2 },
                { 27, 8, 9, 5, 3, 21 },
                { 73, 2, 19, 5, 1, 8 },
                { 47, 9, 9, 5, 0, 22 },
                { 78, 86, 1, 4, 1, 21 },
                { 73, 18, 2, 2, 5, 11 }
        };

        int numRows = 6;
        int numCols = 7;

        int[][] matrix2 = generateRandomMatrix(numRows, numCols);
        int[][] result = multiplyMatrices(matrix, matrix2);

        System.out.println("result length: " + result.length + " x " + result[0].length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; i++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException(
                    "Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] generateRandomMatrix(int numRows, int numCols) {
        int[][] matrix = new int[numRows][numCols];
        Random random = new Random();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = random.nextInt(100); // Generates random values between 0 and 99
            }
        }

        return matrix;
    }

}

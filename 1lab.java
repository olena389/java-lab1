import java.util.Arrays;

public class MatrixOperations {

    public static void main(String[] args) {
        try {
            // Вхідні дані для матриць A та B
            double[][] matrixA = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
            };
            
            double[][] matrixB = {
                {9.0, 8.0, 7.0},
                {6.0, 5.0, 4.0},
                {3.0, 2.0, 1.0}
            };

            // Обчислення добутку матриць A та B
            double[][] matrixC = multiplyMatrices(matrixA, matrixB);
            System.out.println("Matrix C (A * B):");
            printMatrix(matrixC);

            // Обчислення суми найбільших елементів у кожному рядку матриці C
            double sumOfMaxElements = calculateSumOfMaxElements(matrixC);
            System.out.println("Sum of the largest elements in each row of Matrix C: " + sumOfMaxElements);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Метод для множення матриць
    private static double[][] multiplyMatrices(double[][] a, double[][] b) throws IllegalArgumentException {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication.");
        }

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // Метод для обчислення суми найбільших елементів кожного рядка матриці
    private static double calculateSumOfMaxElements(double[][] matrix) {
        double sum = 0.0;

        for (double[] row : matrix) {
            double maxInRow = Arrays.stream(row).max().orElse(Double.NEGATIVE_INFINITY);
            sum += maxInRow;
        }

        return sum;
    }

    // Метод для виведення матриці на екран
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%.2f ", element);
            }
            System.out.println();
        }
    }
}

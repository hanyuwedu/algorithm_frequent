package basicalgorithmsI;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    /**
     * 11/30
     *
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, k = B[0].length;
        int[][] AB = new int[m][k];

        boolean[][] isZero = setZeros(A, B);

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= k - 1; j ++) {
                if (isZero[i][j]) {
                    continue;
                }

                int current = 0;
                for (int l = 0; l <= n - 1; l++) {
                    current += A[i][l] * B[l][j];
                }
                AB[i][j] = current;
            }
        }

        return AB;
    }

    private boolean[][] setZeros(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, k = B[0].length;
        boolean[][] isZero = new boolean[m][k];

        for (int i = 0; i <= m - 1; i++) {
            boolean current = true;
            for (int j = 0; j <= n - 1; j++) {
                if (A[i][j] != 0) {
                    current = false;
                    break;
                }
            }

            if (current) {
                for (int j = 0; j <= k - 1; j++) {
                    isZero[i][j] = true;
                }
            }
        }

        for (int j = 0; j <= k - 1; j++) {
            boolean current = true;
            for (int i = 0; i <= n - 1; i++) {
                if (B[i][j] != 0) {
                    current = false;
                    break;
                }
            }

            if (current) {
                for (int i = 0; i <= m - 1; i++) {
                    isZero[i][j] = true;
                }
            }
        }

        return isZero;
    }

    public static void main(String[] args) {
        int[][] A = {{1}};
        int[][] B = {{1}};

        int[][] AB = new SparseMatrixMultiplication().multiply(A, B);
        for (int i = 0; i <= AB.length - 1; i++) {
            System.out.println(Arrays.toString(AB[i]));
        }
    }
}

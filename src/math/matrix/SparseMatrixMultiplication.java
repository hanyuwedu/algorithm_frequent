package math.matrix;

import java.util.*;

public class SparseMatrixMultiplication {
    /**
     * 12/16
     * Sparse matrix record nontrivial element
     *
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[0][0];
        }

        int m = A.length, n = A[0].length, o = B[0].length;

        Map<Integer, List<Integer>> a_nontrivial = new HashMap<>();
        Map<Integer, List<Integer>> b_nontrivial = new HashMap<>();

        for (int i = 0; i <= m - 1; i++) {
            List<Integer> nontrivial = new ArrayList<>();
            for (int j = 0; j <= n - 1; j++) {
                if (A[i][j] != 0) {
                    nontrivial.add(j);
                }
            }

            a_nontrivial.put(i, nontrivial);
        }

        for (int j = 0; j <= o - 1; j++) {
            List<Integer> nontrivial = new ArrayList<>();
            for (int i = 0; i <= n - 1; i++) {
                if (B[i][j] != 0) {
                    nontrivial.add(i);
                }
            }

            b_nontrivial.put(j, nontrivial);
        }

        int[][] AB = new int[m][o];

        for (int i = 0 ; i <= m - 1; i++) {
            for (int j = 0; j <= o - 1; j++) {
                AB[i][j] = 0;
                List<Integer> a_current_nontrivial = a_nontrivial.get(i), b_current_nontrivial = b_nontrivial.get(j);

                if (a_current_nontrivial.isEmpty() || b_current_nontrivial.isEmpty()) {
                    continue;
                }

                int a = 0, b = 0;
                while (a < a_current_nontrivial.size() && b < b_current_nontrivial.size()) {
                    int a_current = a_current_nontrivial.get(a), b_current = b_current_nontrivial.get(b);
                    if (a_current > b_current) {
                        b++;
                    } else if (a_current < b_current) {
                        a++;
                    } else {
                        AB[i][j] += A[i][a_current] * B[b_current][j];
                        a++;
                        b++;
                    }
                }
            }
        }

        return AB;
    }

    public static void main(String[] args) {
        int[][] A = {{1,0,0},{-1,0,3}};
        int[][] B = {{7,0,0}, {0,0,0}, {0,0,1}};

        int[][] C = new SparseMatrixMultiplication().multiply(A, B);
        print(C);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}

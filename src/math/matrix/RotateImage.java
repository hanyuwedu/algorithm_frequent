package math.matrix;

public class RotateImage {
    /**
     * 12/16
     * Symmatric
     *
     * @param matrix: a lists of integers
     * @return: nothing
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i <= n / 2 - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    /**
     * 12/16
     * 4-quadrant rotation
     *
     * @param matrix: a lists of integers
     * @return: nothing
     */
    public void rotate_quadrant_rotation(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = 0; j <= n / 2 - 1; j++) {
                int[] quadrant_1 = {i, j};
                int[] quadrant_2 = getPos(quadrant_1, n);
                int[] quadrant_3 = getPos(quadrant_2, n);
                int[] quadrant_4 = getPos(quadrant_3, n);

                int temp = matrix[quadrant_1[0]][quadrant_1[1]];
                matrix[quadrant_1[0]][quadrant_1[1]] = matrix[quadrant_4[0]][quadrant_4[1]];
                matrix[quadrant_4[0]][quadrant_4[1]] = matrix[quadrant_3[0]][quadrant_3[1]];
                matrix[quadrant_3[0]][quadrant_3[1]] = matrix[quadrant_2[0]][quadrant_2[1]];
                matrix[quadrant_2[0]][quadrant_2[1]] = temp;
            }
        }
    }

    private int[] getPos(int[] origin, int n) {
        int[] pos = new int[2];
        pos[0] = origin[1];
        pos[1] = n - 1 - origin[0];

        return pos;
    }
}

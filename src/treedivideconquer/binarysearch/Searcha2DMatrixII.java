package treedivideconquer.binarysearch;

import java.util.*;

public class Searcha2DMatrixII {
    /**
     * 12/3
     *
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int count = 0;
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            int current = matrix[row][col];

            if (current > target) {
                row--;
            } else if (current < target) {
                col++;
            } else {
                row--;
                col++;
                count++;
            }
        }

        return count;
    }



    /**
     * 12/3
     *
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix_bfs(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length - 1, n = matrix[0].length - 1;

        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();

        List<Integer> initial = new ArrayList<>();
        initial.add(0);
        initial.add(0);
        queue.add(initial);
        visited.add(initial);
        int count = 0;

        while (!queue.isEmpty()) {
            List<Integer> current = queue.remove();
            int i = current.get(0);
            int j = current.get(1);
            int value = matrix[i][j];
            System.out.println(value);

            if (value == target) {
                count++;
            } else if (value < target) {
                if (i + 1 <= m) {
                    List<Integer> next = new ArrayList<>();
                    next.add(i + 1);
                    next.add(j);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }

                if (j + 1 <= n) {
                    List<Integer> next = new ArrayList<>();
                    next.add(i);
                    next.add(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }


        return count;
    }


    /**
     * 12/3
     * Double binary search
     *
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix_doublybinarysearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int lowerRow = getRow(matrix, target, matrix[0].length - 1, true);
        int upperRow = getRow(matrix, target, 0, false);

        int count = 0;

        for (int i = lowerRow; i <= upperRow; i++) {
            int left = 0, right = matrix[0].length - 1;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                int current = matrix[i][mid];

                if (current > target) {
                    right = mid;
                } else if (current < target) {
                    left = mid;
                } else {
                    count++;
                    break;
                }
            }

            if (matrix[i][left] == target) {
                count++;
            }

            if (matrix[i][right] == target) {
                count++;
            }
        }

        return count;
    }

    private int getRow(int[][] matrix, int target, int j, boolean first) {
        int up = 0, down = matrix.length - 1;
        while (up + 1 < down) {
            int mid = (up + down) / 2;
            int current = matrix[mid][j];

            if (current > target) {
                down = mid;
            } else if (current < target) {
                up = mid;
            } else {
                if (first) {
                    down = mid;
                } else {
                    up = mid;
                }
            }
        }

        if (first) {
            return up;
        } else {
            return down;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3,9}, {2,3,9,10}, {9,100,109,200}};
        System.out.println(new Searcha2DMatrixII().searchMatrix(input, 9));
    }
}

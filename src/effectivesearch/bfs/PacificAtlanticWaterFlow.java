package effectivesearch.bfs;

import java.util.*;

public class PacificAtlanticWaterFlow {
    /**
     * 12/8
     * BFS
     *
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length, n = matrix[0].length;
        Queue<List<Integer>> pacificOcean = new LinkedList<>();
        Queue<List<Integer>> atlanticOcean = new LinkedList<>();

        for (int i = 0; i <= m - 1; i++) {
            pacificOcean.add(getIndex(i, 0));
            atlanticOcean.add(getIndex(i, n - 1));
        }

        for (int j = 0; j <= n - 1; j++) {
            pacificOcean.add(getIndex(0, j));
            atlanticOcean.add(getIndex(m - 1, j));
        }

        boolean[][] pacificFlow = bfs(matrix, pacificOcean);
        boolean[][] atlanticFlow = bfs(matrix, atlanticOcean);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (pacificFlow[i][j] && atlanticFlow[i][j]) {
                    result.add(getIndex(i, j));
                }
            }
        }

        return result;
    }

    private boolean[][] bfs(int[][] matrix, Queue<List<Integer>> ocean) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] flow = new boolean[m][n];
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        for (List<Integer> current : ocean) {
            flow[current.get(0)][current.get(1)] = true;
        }

        while (!ocean.isEmpty()) {
            List<Integer> current = ocean.remove();
            int i = current.get(0), j = current.get(1);

            for (int d = 0; d <= 3; d++) {
                int x = i + dx[d];
                int y = j + dy[d];

                if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                    continue;
                }

                if (flow[x][y]) {
                    continue;
                }

                if (matrix[x][y] >= matrix[i][j]) {
                    ocean.add(getIndex(x, y));
                    flow[x][y] = true;
                }
            }
        }

        return flow;
    }

    private List<Integer> getIndex(int i, int j) {
        List<Integer> index = new ArrayList<>();
        index.add(i);
        index.add(j);

        return index;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> list = new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
        System.out.println(list.toString());
    }
}

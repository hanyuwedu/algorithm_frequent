package effectivesearch.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    private class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * 12/11
     * BFS
     *
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        Point source = new Point(0, 0);
        Point destination = new Point(m - 1, n - 1);

        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, -1, 2, -2}, dy = {2, 2, 1, 1};
        Queue<Point> queue = new LinkedList<>();

        queue.add(source);
        visited[source.x][source.y] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                Point current = queue.remove();
                if (current.x == destination.x && current.y == destination.y) {
                    return step;
                }

                for (int d = 0; d <= 3; d++) {
                    int x = current.x + dx[d];
                    int y = current.y + dy[d];

                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                        continue;
                    }

                    if (visited[x][y]) {
                        continue;
                    }

                    if (grid[x][y]) {
                        continue;
                    }

                    queue.add(new Point(x, y));
                    visited[x][y] = true;
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        board[0][1] = board[1][2] = true;

        System.out.println(new KnightShortestPathII().shortestPath2(board));
    }
}

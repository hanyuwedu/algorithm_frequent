package effectivesearch.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightShortestPath {
    static class Point {
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
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2}, dy = {2, -2, 2, -2, 1, -1, 1, -1};
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

                for (int d = 0; d <= 7; d++) {
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
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);


        System.out.println(new KnightShortestPath().shortestPath(board, p1, p2));
    }
}

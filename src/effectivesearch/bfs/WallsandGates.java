package effectivesearch.bfs;

import java.util.*;

public class WallsandGates {
    /**
     * 12/8
     * BFS
     *
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length, n = rooms[0].length;
        Queue<List<Integer>> queue = new LinkedList<>();


        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(getIndex(i, j));
                }
            }
        }

        int distance = 1;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int l = 1; l <= len; l++) {
                List<Integer> current = queue.remove();
                for (int d = 0; d <= 3; d++) {
                    int x = current.get(0) + dx[d];
                    int y = current.get(1) + dy[d];

                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                        continue;
                    }

                    if (rooms[x][y] == -1) {
                        continue;
                    }

                    if (rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = distance;
                        queue.add(getIndex(x, y));
                    }
                }
            }
            distance++;
        }
    }

    private List<Integer> getIndex(int i, int j) {
        List<Integer> index = new ArrayList<>();
        index.add(i);
        index.add(j);

        return index;
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        new WallsandGates().wallsAndGates(rooms);

        for (int i = 0; i <= rooms.length - 1; i++) {
            System.out.println(Arrays.toString(rooms[i]));
        }
    }
}

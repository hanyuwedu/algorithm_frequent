package effectivesearch.bfs;

import util.UnionFindSet;

import java.util.*;

public class SurroundedRegions {
    /**
     * 12/8
     * BFS
     *
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<List<Integer>> queue = new LinkedList<>();

        for (int i = 0; i <= m - 1; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = true;
                queue.add(getIndex(i, 0));
            }

            if (board[i][n - 1] == 'O') {
                visited[i][n - 1] = true;
                queue.add(getIndex(i, n - 1));
            }
        }

        for (int j = 1; j <= n - 2; j++) {
            if (board[0][j] == 'O') {
                visited[0][j] = true;
                queue.add(getIndex(0, j));
            }

            if (board[m - 1][j] == 'O') {
                visited[m - 1][j] = true;
                queue.add(getIndex(m - 1, j));
            }
        }

        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            List<Integer> current = queue.remove();
            int i = current.get(0), j = current.get(1);

            for (int d = 0; d <= 3; d++) {
                int di = i + dx[d], dj = j + dy[d];
                if (di < 0 || di > m - 1 || dj < 0 || dj > n - 1) {
                    continue;
                }

                if (board[di][dj] == 'O' && !visited[di][dj]) {
                    visited[di][dj] = true;
                    queue.add(getIndex(di, dj));
                }
            }
        }

        for (int i = 1; i <= m - 2; i++) {
            for (int j = 1; j <= n - 2; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 12/8
     * Union find set
     *
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions_unionfind(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        UnionFindSet<List<Integer>> ufs = new UnionFindSet<>();
        Set<List<Integer>> boundaries = new HashSet<>();

        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                        boundaries.add(getIndex(i, j));
                    }
                    ufs.add(getIndex(i, j));

                    for (int d = 0; d <= 3; d++) {
                        int di = i + dx[d], dj = j + dy[d];
                        if (di < 0 || di > board.length - 1 || dj < 0 || dj > board[i].length - 1) {
                            continue;
                        }

                        if (board[di][dj] == 'O') {
                            ufs.add(getIndex(di, dj));
                            ufs.connect(getIndex(i, j), getIndex(di, dj));
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= board.length - 2; i++) {
            for (int j = 1; j <= board[i].length - 2; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';

                    for (List<Integer> boundary : boundaries) {
                        if (ufs.isConnected(getIndex(i, j), boundary)) {
                            board[i][j] = 'O';
                        }
                    }
                }
            }
        }
    }


    private List<Integer> getIndex(int i, int j) {
        List<Integer> index = new ArrayList<>();
        index.add(i);
        index.add(j);

        return index;
    }

    public static void main(String[] args) {
        char[][] chars = {"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
        new SurroundedRegions().surroundedRegions(chars);

        for (int i = 0; i <= chars.length - 1; i++) {
            System.out.println(Arrays.toString(chars[i]));
        }


    }
}

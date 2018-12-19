package gameday;

import java.util.*;

public class SlidingPuzzleII {
    /**
     * 12/12
     * BFS with parallel queue and serialize String
     *
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        String start = serialize(init_state), end = serialize(final_state);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> centerPos = new LinkedList<>();

        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        visited.add(start);
        queue.add(start);
        centerPos.add(start.indexOf('0'));
        int move = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int l = 1; l <= len; l++) {
                String current = queue.remove();
                int center = centerPos.remove();
                if (current.equals(end)) {
                    return move;
                }

                int i = center / 3, j = center % 3;
                for (int d = 0; d <= 3; d++) {
                    int x = i + dx[d], y = j + dy[d];
                    if (x < 0 || x > 2 || y < 0 || y > 2) {
                        continue;
                    }
                    int newCenter = x * 3 + y;

                    char[] chars = current.toCharArray();
                    chars[center] = chars[newCenter];
                    chars[newCenter] = '0';

                    String next = new String(chars);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                        centerPos.add(newCenter);
                    }
                }
            }

            move++;
        }

        return -1;
    }

    private String serialize(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                builder.append(board[i][j]);
            }
        }

        return builder.toString();
    }
}

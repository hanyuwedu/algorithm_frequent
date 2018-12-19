package effectivesearch.bfs;

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



    /**
     * 12/11
     * BFS
     *
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep_original(int[][] init_state, int[][] final_state) {
        List<String> start = serializeToList(init_state);
        List<String> end = serializeToList(final_state);

        Set<List<String>> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);
        int move = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                List<String> current = queue.remove();
                if (current.equals(end)) {
                    return move;
                }

                for (List<String> next : getSwap(current)) {
                    if (visited.contains(next)) {
                        continue;
                    }

                    queue.add(next);
                    visited.add(next);
                }
            }
            move++;
        }

        return -1;
    }

    private List<List<String>> getSwap(List<String> current) {
        List<List<String>> swaps = new ArrayList<>();
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

        for (int i = 0; i <= 2; i++) {
            int j = current.get(i).indexOf('0');
            if (j == -1) {
                continue;
            }

            for (int d = 0; d <= 3; d++) {
                int x = i + dx[d];
                int y = j + dy[d];

                if (x < 0 || x > 2 || y < 0 || y > 2) {
                    continue;
                }

                List<String> next = new ArrayList<>(current);

                if (i == x) {
                    char[] chars = next.get(i).toCharArray();
                    chars[j] = chars[y];
                    chars[y] = '0';
                    next.set(i, new String(chars));
                } else {
                    char[] chars_a = next.get(i).toCharArray();
                    char[] chars_b = next.get(x).toCharArray();
                    chars_a[j] = chars_b[y];
                    chars_b[y] = '0';

                    next.set(i, new String(chars_a));
                    next.set(x, new String(chars_b));
                }

                swaps.add(next);
            }
        }

        return swaps;
    }



    private List<String> serializeToList(int[][] board) {
        List<String> state = new ArrayList<>();
        for (int i = 0; i <= board.length - 1; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j <= 2; j++) {
                builder.append(board[i][j]);
            }
            state.add(builder.toString());
        }

        return state;
    }

    public static void main (String[] args) {
        int[][] start = {{0,3,4},{6,1,8},{7,2,5}};
        int[][] end = {{1,2,3},{4,5,6},{7,8,0}};

        System.out.println(new SlidingPuzzleII().minMoveStep(start, end));


        StringBuilder builder = new StringBuilder();
        builder.deleteCharAt(builder.length() - 1);
    }
}

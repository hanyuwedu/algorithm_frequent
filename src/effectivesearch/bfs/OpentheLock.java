package effectivesearch.bfs;

import java.util.*;

public class OpentheLock {
    /**
     * 12/11
     * BFS
     *
     * @param deadends: the list of deadends
     * @param target: the value of the wheels that will unlock the lock
     * @return: the minimum total number of turns
     */
    public int openLock(String[] deadends, String target) {
        Set<String> locks = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for (String str : deadends) {
            if (str.equals("0000")) {
                return -1;
            }
            locks.add(str);
        }

        queue.add("0000");
        visited.add("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 1; i <= len; i++) {
                String current = queue.remove();
                if (current.equals(target)) {
                    return step;
                }

                for (String next : rotate(current)) {
                    if (locks.contains(next) || visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
            step++;
        }

        return -1;
    }

    private List<String> rotate(String current) {
        List<String> rotations = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i <= chars.length - 1; i++) {
            int c = chars[i] - '0';
            int u = (c + 1 + 10) % 10;
            int l = (c - 1 + 10) % 10;

            chars[i] = (char) (u + '0');
            rotations.add(new String(chars));

            chars[i] = (char) (l + '0');
            rotations.add(new String(chars));

            chars[i] = (char) (c + '0');
        }

        return rotations;
    }

    public static void main(String[] args) {
        String[] strs = {"8888"};

        System.out.println(new OpentheLock().openLock(strs, "0009"));

        System.out.println(((char) (5 + '0')));

        System.out.println(-1 % 10);
    }
}

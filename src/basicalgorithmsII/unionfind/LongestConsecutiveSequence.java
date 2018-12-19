package basicalgorithmsII.unionfind;

import util.UnionFindSet;

import java.util.*;

public class LongestConsecutiveSequence {
    /**
     * 12/1
     * Union Find
     *
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        UnionFindSet<Integer> unionFind = new UnionFindSet<>();

        for (int i : num) {
            if (unionFind.contains(i)) {
                continue;
            }
            unionFind.add(i);
        }

        for (int i : num) {
            if (unionFind.contains(i + 1)) {
                unionFind.connect(i, i + 1);
            }

            if (unionFind.contains(i - 1)) {
                unionFind.connect(i, i - 1);
            }
        }


        int longest = 0;
        for (Set<Integer> component : unionFind.connectedComponents()) {
            longest = Math.max(longest, component.size());
        }

        return longest;
    }

    /**
     * 12/1
     * two direction expansion
     *
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive_twoDirectionExpansion(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        for (int i : num) {
            visited.add(i);
        }

        int longest = 0;

        for (int i : num) {
            if (!visited.contains(i)) {
                continue;
            }

            int current = 1;
            visited.remove(i);

            for (int j = i + 1; visited.contains(j); j++) {
                visited.remove(j);
                current++;
            }

            for (int j = i - 1; visited.contains(j); j--) {
                visited.remove(j);
                current++;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }



    public static void main(String[] args) {
        int[] input = {0,0,-1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(input));
    }
}

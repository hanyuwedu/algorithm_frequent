package gameday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Factorization {
    /**
     * 12/11
     * DFS
     *
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> current = new Stack<>();

        dfs(result, current, n, 2);
        return result;
    }

    private void dfs(List<List<Integer>> result, Stack<Integer> current, int left, int start) {
        if (left == 1) {
            if (current.size() != 1) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i * i <= left; i++) {
            if (left % i != 0) {
                continue;
            }

            current.push(i);
            dfs(result, current, left / i, i);
            current.pop();
        }

        current.push(left);
        dfs(result, current, 1, -10086);
        current.pop();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Factorization().getFactors(60);
        System.out.println(result);
    }
}

package effectivesearch.dfs;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    /**
     * 12/10
     *
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(num, target, result, 0, "", 0, 0);

        return result;
    }

    private void dfs(String num, int target, List<String> result, int pos, String current, long eval, long last) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(current);
            }
            return;
        }

        for (int i = pos + 1; i <= num.length(); i++) {
            if (num.charAt(pos) == '0' && i > pos + 1) {
                break;
            }

            String nextStr = num.substring(pos, i);
            long nextInt = Long.valueOf(nextStr);

            if (pos == 0) {
                dfs(num, target, result, i, nextStr, nextInt, nextInt);
                continue;
            }

            dfs(num, target, result, i, current + "+" + nextStr, eval + nextInt, nextInt);
            dfs(num, target, result, i, current + "-" + nextStr, eval - nextInt, -nextInt);
            dfs(num, target, result, i, current + "*" + nextStr, eval - last + last * nextInt, last * nextInt);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ExpressionAddOperators().addOperators("123", 6));
        System.out.println(new ExpressionAddOperators().addOperators("232", 8));
        System.out.println(new ExpressionAddOperators().addOperators("105", 5));
        System.out.println(new ExpressionAddOperators().addOperators("00", 0));
        System.out.println(new ExpressionAddOperators().addOperators("3456237490", 9191));
    }

}

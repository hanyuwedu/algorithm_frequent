package treedivideconquer.dynamicprogramming;

import java.util.*;

public class WordBreakII {
    /**
     * 12/3
     * Memorized Divide and Conquer
     *
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Map<String, List<List<String>>> cache = new HashMap<>();
        List<List<String>> breaks = divideConquer(s, cache, wordDict);

        return collectToString(breaks);
    }

    private List<List<String>> divideConquer(String str, Map<String, List<List<String>>> cache, Set<String> wordDict) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }

        if (cache.containsKey(str)) {
            return cache.get(str);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= str.length(); i++) {
            String pre = str.substring(0, i);

            if (wordDict.contains(pre)) {
                List<List<String>> postBreaks = divideConquer(str.substring(i, str.length()), cache, wordDict);
                if (postBreaks.isEmpty()) {
                    continue;
                }

                for (List<String> current : postBreaks) {
                    List<String> temp = new ArrayList<>();
                    temp.add(pre);
                    temp.addAll(current);
                    result.add(temp);
                    System.out.println(result);
                }
            }
        }

        if (!result.isEmpty()) {
            cache.put(str, result);
        }

        return result;
    }



    /**
     * 12/3
     * DFS
     *
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak_dfs(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> breaks = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        dfs(breaks, stack, 0, s, wordDict);

        return collectToString(breaks);
    }

    private void dfs(List<List<String>> breaks, Stack<String> stack, int index, String s, Set<String> wordDict) {
        if (index == s.length()) {
            List<String> current = new ArrayList<>(stack);
            breaks.add(current);
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String next = s.substring(index, i);
            if (wordDict.contains(next)) {
                stack.push(next);
                dfs(breaks, stack, i, s, wordDict);
                stack.pop();
            }
        }
    }

    private List<String> collectToString(List<List<String>> breaks) {
        List<String> list = new ArrayList<>();

        for (List<String> current : breaks) {
            String str = current.get(0);
            for (int i = 1; i <= current.size() - 1; i++) {
                str += " " + current.get(i);
            }

            list.add(str);
        }

        return list;
    }
//    /**
//     * 12/3
//     * DP
//     *
//     * @param s: A string
//     * @param wordDict: A set of words.
//     * @return: All possible sentences.
//     */
//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        if (s.length() == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<List<String>>> component = new ArrayList<>();
//        List<List<String>> initial = new ArrayList<>();
//        initial.add(new ArrayList<>());
//        component.add(initial);
//
//        System.out.println(component.get(0).size());
//
//        for (int i = 1; i <= s.length(); i++) {
//            component.add(new ArrayList<>());
//            for (int j = 0; j <= i - 1; j++) {
//                if (!component.get(j).isEmpty() && wordDict.contains(s.substring(j, i))) {
//                    for (List list : component.get(i)) {
//                        for (List<String> current : list) {
//
//                        }
//                        List<List<String>> current = new ArrayList<>(list);
//                        current.add(s.substring(j, i));
//                        component.get(i).add(current);
//                    }
//                }
//            }
//        }
//
//        List<String> result = new ArrayList<>();
//        for (List<String> cut : component.get(s.length())) {
//            String current = cut.get(0);
//            for (int i = 1; i <= cut.size() - 1; i++) {
//                current += " " + cut.get(i);
//            }
//            result.add(current);
//        }
//
//        return result;
//    }



    public static void main(String[] args) {
        String[] strs = {"de", "ding", "co", "code", "lint"};
        Set<String> dict = new HashSet<>(Arrays.asList(strs));

        System.out.println(new WordBreakII().wordBreak("de", dict));
    }
}

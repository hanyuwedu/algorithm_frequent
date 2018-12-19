package effectivesearch.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {
    /**
     * 12/10
     * DFS
     *
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> prefixes = getPrefix(words);

        System.out.println(prefixes);

        List<List<String>> result = new ArrayList<>();
        List<String> square = new ArrayList<>();

        dfs(0, words[0].length(), result, square, prefixes);
        return result;
    }



    private Map<String,List<String>> getPrefix(String[] words) {
        Map<String, List<String>> prefixes = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                prefixes.putIfAbsent(prefix, new ArrayList<>());

                prefixes.get(prefix).add(word);
            }
        }

        return prefixes;
    }

    private void dfs(int len, int wordLen, List<List<String>> result, List<String> square, Map<String,List<String>> prefixes) {
        if (len == wordLen) {
            result.add(new ArrayList<>(square));
            return;
        }

        String prefix = "";
        for (int i = 0; i < len; i++) {
            prefix += square.get(i).charAt(len);
        }

        if (prefixes.containsKey(prefix)) {
            for (String next : prefixes.get(prefix)) {
                square.add(next);
                dfs(len + 1, wordLen, result, square, prefixes);
                square.remove(square.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"abat","baba","atan","atal"};
        System.out.println(new WordSquares().wordSquares(words));
    }
}

package effectivesearch.dfs;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    /**
     * 12/14
     * DFS with character abbr boolean array
     *
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations(String word) {
        if (word == null || word.length() == 0) {
            return new ArrayList<>();
        }

        boolean[] abbr = new boolean[word.length()];
        List<String> result = new ArrayList<>();

        dfs(0, word, abbr, result);
        return result;
    }

    private void dfs(int index, String word, boolean[] abbr, List<String> result) {
        if (index == abbr.length) {
            String str = getAbbr(word, abbr);
            result.add(str);
            return;
        }

        dfs(index + 1, word, abbr, result);
        abbr[index] = true;
        dfs(index + 1, word, abbr, result);
        abbr[index] = false;
    }

    private String getAbbr(String word, boolean[] abbr) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < abbr.length) {
            if (!abbr[i]) {
                builder.append(word.charAt(i));
                i++;
            } else {
                int j = i;
                while (j < abbr.length && abbr[j]) {
                    j++;
                }

                builder.append(j - i);
                i = j;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GeneralizedAbbreviation().generateAbbreviations("word"));
    }
}

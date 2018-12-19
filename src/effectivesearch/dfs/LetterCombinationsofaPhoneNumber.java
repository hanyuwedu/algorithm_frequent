package effectivesearch.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    /**
     * 12/12
     *
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<Character>> code = getCode();
        List<String> combinations = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(0, digits, builder, combinations, code);

        return combinations;
    }

    private void dfs(int current, String digits, StringBuilder builder, List<String> combinations, Map<Character,List<Character>> code) {
        if (current == digits.length()) {
            combinations.add(new String(builder));
            return;
        }

        for (Character c : code.get(digits.charAt(current))) {
            builder.append(c);
            dfs(current + 1, digits, builder, combinations, code);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private Map<Character,List<Character>> getCode() {
        Map<Character,List<Character>> code = new HashMap<>();
        char letter = 'a';
        for (Character digit = '2'; digit <= '9'; digit++) {
            code.put(digit, new ArrayList<>());

            for (int i = 1; i <= 4; i++) {
                if (i == 4 && digit != '7' && digit != '9') {
                    continue;
                }
                code.get(digit).add(letter);
                letter = (char) (letter + 1);
            }
        }

        return code;
    }

    public static void main(String[] args) {
        Map<Character,List<Character>> code = new LetterCombinationsofaPhoneNumber().getCode();
        System.out.println(code);

        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("7"));
    }
}

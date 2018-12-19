package basicalgorithmsII.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> starts = new ArrayList<>();
        Map<Character, Integer> target = getLetterFrequency(p);
        int left = 0, right = p.length();
        Map<Character, Integer> current = getLetterFrequency(s.substring(left, right));

        if (current.equals(target)) {
            starts.add(left);
        }

        while (right <= s.length() - 1) {
            current.put(s.charAt(left), current.get(s.charAt(left)) - 1);
            if (current.get(s.charAt(left)) == 0) {
                current.remove(s.charAt(left));
            }

            current.put(s.charAt(right), current.getOrDefault(s.charAt(right), 0) + 1);

            left++;
            right++;

            if (current.equals(target)) {
                starts.add(left);
            }
        }

        return starts;
    }

    private Map<Character, Integer> getLetterFrequency(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> frequency = new HashMap<>();

        for (char current : chars) {
            frequency.put(current, frequency.getOrDefault(current, 0) + 1);
        }

        return frequency;
    }
}

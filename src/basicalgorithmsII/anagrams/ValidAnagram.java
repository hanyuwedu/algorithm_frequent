package basicalgorithmsII.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /**
     * 12/1
     * Sorted Anagram
     *
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram_bySortedAnagram(String s, String t) {
        String sSorted = getSortedAnagram(s);
        String tSorted = getSortedAnagram(t);

        return sSorted.equals(tSorted);
    }

    private String getSortedAnagram(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 12/1
     * Letter frequency
     *
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram_byLetterFrequency(String s, String t) {
        Map<Character, Integer> sFrequency = getLetterFrequency(s);
        Map<Character, Integer> tFrequency = getLetterFrequency(t);

        for (Character c: sFrequency.keySet()) {
            if (!tFrequency.containsKey(c) || tFrequency.get(c) != sFrequency.get(c)) {
                return false;
            }
        }

        return sFrequency.keySet().size() == tFrequency.keySet().size();
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

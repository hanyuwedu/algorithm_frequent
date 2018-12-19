package basicalgorithmsII.anagrams;

import java.util.*;

public class GroupAnagrams {
    /**
     * 12/1
     * Frequency by chars
     *
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        int[] sChars = getChars(s);
        int[] tChars = getChars(t);

        for (int i = 0; i <= sChars.length - 1; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getChars(String str) {
        int[] frequency = new int[256];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            frequency[(int) c]++;
        }

        return frequency;
    }


    /**
     * 12/1
     *
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            String sortedAnagram = getSortedAnagram(str);
            if (anagrams.containsKey(sortedAnagram)) {
                anagrams.get(sortedAnagram).add(str);
            } else {
                List<String> current = new ArrayList<>();
                current.add(str);
                anagrams.put(sortedAnagram, current);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> anagramList : anagrams.values()) {
            result.add(anagramList);
        }

        return result;
    }

    private String getSortedAnagram(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(input));
    }
}

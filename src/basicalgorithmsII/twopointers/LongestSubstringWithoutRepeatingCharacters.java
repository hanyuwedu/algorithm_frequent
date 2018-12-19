package basicalgorithmsII.twopointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 12/1
     *
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0, longest = 0;
        Set<Character> visited = new HashSet<>();

        while (right < s.length()) {
            if (visited.contains(s.charAt(right))) {
                visited.remove(s.charAt(left));
                left++;
            } else {
                visited.add(s.charAt(right));
                right++;
                longest = Math.max(longest, right - left);
            }
        }

        return longest;
    }
}

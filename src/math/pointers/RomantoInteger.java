package math.pointers;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    /**
     * 11/28
     *
     * @param s: Roman representation
     * @return: an integer
     */
    public int romanToInt(String s) {
        Map<Character, Integer> digit = new HashMap<>();
        digit.put('I', 1);
        digit.put('V', 5);
        digit.put('X', 10);
        digit.put('L', 50);
        digit.put('C', 100);
        digit.put('D', 500);
        digit.put('M', 1000);

        int sum = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i <= chars.length - 1; i++) {
            if (i + 1 <= chars.length - 1 && digit.get(chars[i]) < digit.get(chars[i + 1])) {
                sum -= digit.get(chars[i]);
            } else {
                sum += digit.get(chars[i]);
            }
        }

        return sum;
    }
}

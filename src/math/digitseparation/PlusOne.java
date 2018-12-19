package math.digitseparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    /**
     * 12/16
     * Digit separation
     *
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        int carry = 0;

        digits[digits.length - 1] += 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int current = carry + digits[i];
            result.add(current % 10);
            carry = current / 10;
        }

        if (carry > 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

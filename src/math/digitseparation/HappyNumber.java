package math.digitseparation;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     * 12/16
     * Digit separation
     *
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        Set<Integer> visited= new HashSet<>();
        visited.add(n);

        while (n != 1) {
            int next = getNext(n);
            if (visited.contains(next)) {
                return false;
            }

            visited.add(next);
            n = next;
        }

        return true;
    }

    private int getNext(int n) {
        int next = 0;
        while (n != 0) {
            next += Math.pow(n % 10, 2);
            n = n / 10;
        }

        return next;
    }
}

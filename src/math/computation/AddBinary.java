package math.computation;

public class AddBinary {
    /**
     * 12/16
     *
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }

        if (b.length() == 0) {
            return a;
        }

        int carry = 0;
        String ans = "";

        int m = a.length() -1, n = b.length() - 1;
        while (m >= 0 || n >= 0 || carry > 0) {
            int current = carry;
            if (m >= 0) {
                current += a.charAt(m) - '0';
                m--;
            }

            if (n >= 0) {
                current += b.charAt(n) - '0';
                n--;
            }

            ans = "" + (current % 2) + ans;
            carry = current / 2;
        }

        return ans;
    }
}

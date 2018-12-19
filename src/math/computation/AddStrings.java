package math.computation;

import java.util.Arrays;

public class AddStrings {
    /**
     * 12/16
     * separate advancing
     *
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }

        if (num2.length() == 0) {
            return num1;
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[Math.max(m, n) + 1];

        for (int i = 0; i <= result.length - 1; i++) {
            if (i <= m - 1) {
                result[result.length - 1 - i] += num1.charAt(m - 1 - i) - '0';
            }

            if (i <= n - 1) {
                result[result.length - 1 - i] += num2.charAt(n - 1 - i) - '0';
            }
            System.out.println(Arrays.toString(result));
        }

        int carry = 0;
        String str = "";
        for (int i = result.length - 1; i >= 0; i--) {
            int current = result[i] + carry;
            str = "" + (current % 10) + str;
            carry = current / 10;
        }

        str = str.replaceAll("^0*", "");
        return str.length() == 0 ? "0" : str;
    }


    /**
     * 12/16
     * Linkedlist advancing
     *
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings_simultAdvancing(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }

        if (num2.length() == 0) {
            return num1;
        }

        int m = num1.length() - 1, n = num2.length() - 1;
        String result = "";
        int carry = 0;

        while (m >= 0 || n >= 0 || carry > 0) {
            int next = carry;
            if (m >= 0) {
                next += num1.charAt(m) - '0';
                m--;
            }

            if (n >= 0) {
                next += num2.charAt(n) - '0';
                n--;
            }

            result = "" + next % 10  + result;
            carry = next / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("123", "45"));

//        String kk = "00000123";
//        System.out.println(kk.replaceAll("^0*", ""));
    }
}

package math.computation;

public class MultiplyStrings {
    /**
     * 12/16
     * Reverse String and count from left to right
     *
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        String a = new StringBuilder(num1).reverse().toString();
        String b = new StringBuilder(num2).reverse().toString();

        int[] ans = new int[m + n + 1];

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                ans[i + j] += (a.charAt(i) - '0') * (b.charAt(j) - '0');
            }
        }

        String result = "";
        int carry = 0;

        for (int i = 0; i <= ans.length - 1; i++) {
            int current = carry + ans[i];
            result = "" + current % 10 + result;
            carry = current / 10;
        }

        result = result.replaceAll("^0*", "");
        return result.length() == 0 ? "0" : result;
    }



    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "45"));
    }
}

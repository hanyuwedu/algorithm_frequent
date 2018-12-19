package math.digitseparation;

public class PalindromeNumber {
    /**
     * 11/28
     *
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        long reversedLong = reverseIntegerToLong(num);
        return reversedLong == (long) num;
    }

    private long reverseIntegerToLong(int num) {
        long reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }

        return reverse;
    }
}

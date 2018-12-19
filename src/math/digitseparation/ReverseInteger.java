package math.digitseparation;

public class ReverseInteger {
    /**
     * 11/28
     *
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        long reverse = 0;
        while (n != 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }

        if (reverse > (long) Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) reverse;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverseInteger(1534236469));
    }
}

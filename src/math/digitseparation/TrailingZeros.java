package math.digitseparation;

public class TrailingZeros {
    /**
     * 11/28
     *
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long zeros = 0;

        while (n >= 5) {
            zeros += n / 5;
            n = n / 5;
        }

        return zeros;
    }
}

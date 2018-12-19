package math.digitseparation;

public class IntegertoRoman {
    /**
     * 11/28
     *
     * @param n: The integer
     * @return: Roman representation
     */
    public String intToRoman(int n) {
        if (n < 1 || n > 3999) {
            throw new IllegalArgumentException("input is too large");
        }

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        StringBuilder builder = new StringBuilder();
        builder.append(thousands[n / 1000]);
        n = n % 1000;
        builder.append(hundreds[n / 100]);
        n = n % 100;
        builder.append(tens[n / 10]);
        n = n % 10;
        builder.append(ones[n]);

        return builder.toString();
    }
}

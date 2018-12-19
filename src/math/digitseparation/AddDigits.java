package math.digitseparation;

public class AddDigits {
    /**
     * 11/28
     *
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        while (num > 9) {
            int current = 0;
            while (num > 0) {
                current += num % 10;
                num = num / 10;
            }

            num = current;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }
}

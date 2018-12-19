package basicalgorithmsI;

public class ValidNumber {
    /**
     * 11/30
     *
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }

        char[] chars = s.replaceAll("\\s","").toCharArray();

        if (chars.length == 0) {
            return false;
        }

        int current = 0;
        boolean isValid = false;

        if (chars[0] == '+' || chars[0] == '-') {
            current++;
        }

        while (current < chars.length) {
            if (chars[current] - '0' >= 0 && chars[current] - '0' <= 9) {
                isValid = true;
                current++;
            } else {
                break;
            }
        }

        if (current == chars.length) {
            return true;
        }

        if (chars[current] == '.') {
            current++;
            while (current < chars.length) {
                if (chars[current] - '0' >= 0 && chars[current] - '0' <= 9) {
                    isValid = true;
                    current++;
                } else {
                    break;
                }
            }
        }

        if (current == chars.length) {
            return isValid;
        }

        if (!isValid) {
            return false;
        }

        if (chars[current] == 'e') {
            current++;

            if (current == chars.length) {
                return false;
            }

            if (chars[current] == '+' || chars[current] == '-') {
                current++;
            }

            isValid = false;
            while (current < chars.length) {
                if (chars[current] - '0' >= 0 && chars[current] - '0' <= 9) {
                    current++;
                    isValid = true;
                } else {
                    break;
                }
            }
        }

        return isValid && current == chars.length;
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("2."));
    }
}

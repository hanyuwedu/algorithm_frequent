package interviewstyle;

public class ValidWordAbbreviation {
    /**
     * 11/24
     *
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int left = 0, right = 0;

        while (left < abbr.length()) {
            if (Character.isDigit(abbr.charAt(left))) {
                if (abbr.charAt(left) == '0') {
                    return false;
                }

                int end = left;
                while (end < abbr.length() && Character.isDigit(abbr.charAt(end))) {
                    end++;
                }

                if (right + Integer.valueOf(abbr.substring(left, end)) > word.length()) {
                    return false;
                } else {
                    right += Integer.valueOf(abbr.substring(left, end));
                    left = end;
                }
            } else {
                if (abbr.charAt(left) == word.charAt(right)) {
                    left++;
                    right++;
                } else {
                    return false;
                }
            }
        }

        return right == word.length();
    }

    public static void main(String[] args) {
        System.out.println(new ValidWordAbbreviation().validWordAbbreviation("internationalization", "i12iz4n"));
    }
}

package basicalgorithmsII.hash;

public class FirstPositionUniqueCharacter {
    /**
     * 12/1
     *
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int[] frequency = new int[256];

        for (int i = 0; i <= chars.length - 1; i++) {
            frequency[(int) chars[i]]++;
        }

        for (int i = 0; i <= chars.length - 1; i++) {
            if (frequency[(int) chars[i]] == 1) {
                return i;
            }
        }

        return -1;
    }
}

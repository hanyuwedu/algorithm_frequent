package interviewstyle;

public class DecodeWays {
    /**
     * 11/30
     * DFS
     *
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings_dfs(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] ways = {0};
        dfs(s, ways, 0);
        return ways[0];
    }

    private void dfs(String s, int[] ways, int current) {
        if (current == s.length()) {
            ways[0] = ways[0] + 1;
            return;
        }

        if (Integer.valueOf(s.substring(current, current + 1)) > 0) {
            dfs(s, ways, current + 1);
        }

        if (current + 2 <= s.length() && Integer.valueOf(s.substring(current, current + 2)) <= 26 && Integer.valueOf(s.substring(current, current + 2)) >= 10) {
            dfs(s, ways, current + 2);
        }
    }


    /**
     * 11/20
     * DP
     *
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = Integer.valueOf(s.substring(0, 1)) == 0 ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            if (Integer.valueOf(s.substring(i - 1, i)) > 0) {
                ways[i] = ways[i] + ways[i - 1];
            }

            if (Integer.valueOf(s.substring(i - 2, i)) >= 10 &&
                    Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                ways[i] = ways[i] + ways[i - 2];
            }
        }

        return ways[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }
}

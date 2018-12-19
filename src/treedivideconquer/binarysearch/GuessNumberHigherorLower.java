package treedivideconquer.binarysearch;

public class GuessNumberHigherorLower {
    private int guess(int n) {
        return 0;
    }


    /**
     * 12/3
     *
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int current = guess(mid);

            if (current == 1) {
                left = mid;
            } else if (current == -1) {
                right = mid;
            } else {
                return mid;
            }
        }

        if (guess(left) == 0) {
            return left;
        } else {
            return right;
        }
    }
}

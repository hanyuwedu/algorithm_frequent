package basicalgorithmsI;

public class FindtheCelebrity {
    public class Relation {
        protected boolean knows(int a, int b) {
            return false;
        }
    }


    public class Solution extends Relation {
        /**
         * 11/30
         *
         * @param n a party with n people
         * @return the celebrity's label or -1
         */
        public int findCelebrity(int n) {
            if (n == 0) {
                return -1;
            }

            int celebrity = 0;
            for (int i = 1; i <= n - 1; i++) {
                if (knows(celebrity, i)) {
                    celebrity = i;
                }
            }

            for (int i = 0; i <= n - 1; i++) {
                if (i == celebrity) {
                    continue;
                }

                if (knows(celebrity, i) || !knows(i, celebrity)) {
                    return -1;
                }
            }

            return celebrity;
        }
    }
}

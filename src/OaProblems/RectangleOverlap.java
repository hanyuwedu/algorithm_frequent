package OaProblems;

public class RectangleOverlap {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * 11/30
     *
     * @param l1: top-left coordinate of first rectangle
     * @param r1: bottom-right coordinate of first rectangle
     * @param l2: top-left coordinate of second rectangle
     * @param r2: bottom-right coordinate of second rectangle
     * @return: true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        if (r1.x < l2.x) {
            return false;
        }

        if (l1.x > r2.x) {
            return false;
        }

        if (l1.y < r2.y) {
            return false;
        }

        if (r1.y > l2.y) {
            return false;
        }

        return true;

        // return r1.x >= l2.x && l1.x <= r2.x && l1.y >= r2.y && r1.y <= l2.y;
    }
}

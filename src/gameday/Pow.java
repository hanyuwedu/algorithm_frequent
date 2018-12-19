package gameday;

import java.util.ArrayList;
import java.util.List;

public class Pow {
    /**
     * 11/28
     *
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            m = -m;
            x = 1.0 / x;
        }

        List<Long> exponentials = new ArrayList<>();
        List<Double> powers = new ArrayList<>();

        long exponential = 1;
        Double power = x;

        while (exponential <= m) {
            powers.add(power);
            exponentials.add(exponential);

            power = power * power;
            exponential = exponential * 2;
        }


        double result = 1.0;
        for (int i = exponentials.size() - 1; i >= 0; i--) {
            if (m / exponentials.get(i) > 0) {
                result = result * powers.get(i);
                m = m - exponentials.get(i);
            }
        }

        return result;
    }
}

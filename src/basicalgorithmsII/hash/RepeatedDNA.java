package basicalgorithmsII.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA {
    private final int DNALENGTH = 10;

    /**
     * 12/1
     *
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences
     */
    public List<String> findRepeatedDna(String s) {
        if (s == null || s.length() < DNALENGTH) {
            return new ArrayList<>();
        }

        Map<String, Integer> repeat = new HashMap<>();
        for (int i = 0; i + DNALENGTH <= s.length(); i++) {
            String current = s.substring(i, i + DNALENGTH);
            repeat.put(current, repeat.getOrDefault(current, 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : repeat.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}

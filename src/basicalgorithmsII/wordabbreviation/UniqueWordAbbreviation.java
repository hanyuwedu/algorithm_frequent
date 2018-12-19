package basicalgorithmsII.wordabbreviation;

import java.util.*;

/**
 * 12/1
 */
public class UniqueWordAbbreviation {
    private Set<String> strs;
    private Map<String, List<String>> abbrs;

    /*
     * @param dictionary: a list of words
     */public UniqueWordAbbreviation(String[] dictionary) {
        this.strs = new HashSet<>();
        this.abbrs = new HashMap<>();

        for (String str : dictionary) {
            strs.add(str);
        }

        for (String str : strs) {
            String abbr = getAbbr(str);
            if (abbrs.containsKey(abbr)) {
                abbrs.get(abbr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                abbrs.put(abbr, list);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!this.abbrs.containsKey(abbr) || (this.abbrs.get(abbr).size() == 1 && this.strs.contains(word))) {
            return true;
        } else {
            return false;
        }
    }

    private String getAbbr(String str) {
        if (str.length() <= 2) {
            return str;
        }

        int abbrDigit = str.length() - 2;
        String abbr = str.charAt(0) + "" + abbrDigit + str.charAt(str.length() - 1);

        return abbr;
    }
}

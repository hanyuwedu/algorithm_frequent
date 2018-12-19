package basicalgorithmsII.wordabbreviation;

import java.util.*;

public class WordAbbreviation {
    /**
     * 12/1
     *
     * @param dict: an array of n distinct non-empty strings
     * @return: an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        if (dict == null || dict.length == 0) {
            return new String[0];
        }

        String[] abbrs = new String[dict.length];
        Map<String, List<Integer>> visited = new HashMap<>();

        for (int i = 0; i <= dict.length - 1; i++) {
            String abbr = getAbbr(dict[i], 0);
            if (visited.containsKey(abbr)) {
                visited.get(abbr).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                visited.put(abbr, list);
            }
            abbrs[i] = abbr;
        }

        for (int level = 1; ; level++) {
            boolean isValid = true;

//            for (String abbr : visited.keySet()) {
//                if (visited.get(abbr).size() != 1) {
//                    isValid = false;
//                    for (int j : visited.get(abbr)) {
//                        String updateAbbr = getAbbr(dict[j], level);
//                        if (visited.containsKey(updateAbbr)) {
//                            visited.get(updateAbbr).add(j);
//                        } else {
//                            List<Integer> list = new ArrayList<>();
//                            list.add(j);
//                            visited.put(updateAbbr, list);
//                        }
//                        abbrs[j] = updateAbbr;
//                    }
//
//                    visited.remove(abbr);
//                    break;
//                }
//            }

            for (String abbr : abbrs) {
                if (visited.get(abbr).size() == 1) {
                    continue;
                }

                isValid = false;
                for (int j : visited.get(abbr)) {
                    String updateAbbr = getAbbr(dict[j], level);
                    if (visited.containsKey(updateAbbr)) {
                        visited.get(updateAbbr).add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        visited.put(updateAbbr, list);
                    }
                    abbrs[j] = updateAbbr;
                }

                visited.remove(abbr);
            }

            if (isValid) {
                break;
            }
        }

        return abbrs;
    }


    private String getAbbr(String str, int left) {
        if (str.length() < 3 + left) {
            return str;
        }

        int abbrDigit = str.length() - 2 - left;
        String abbr = str.substring(0, left + 1) + abbrDigit + str.charAt(str.length() - 1);

        if (abbr.length() < str.length()) {
            return abbr;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        String[] input = {"aaaaaaaaaaaaaaaaabbbbbbbbbbkjufifeudlk", "aaaaaaaaaaaaaaaaabbbbbbbbbbojqbrmfsyfqqsrwhled", "aaaaaaaaaaaaaaaaabbbbbbbbbbolhhvpdpkfoidvsqqpd", "aaaaaaaaaaaaaaaaabbbbbbbbbbwzrnlhyendbfhepobh", "aaaaaaaaaaaaaaaaabbbbbbbbbbopsdoysmslhriwwwu", "aaaaaaaaaaaaaaaaabbbbbbbbbbbwjevqdzacev", "aaaaaaaaaaaaaaaaabbbbbbbbbbrhweyqriepzroy", "aaaaaaaaaaaaaaaaabbbbbbbbbbcnjfjigbhlklazdqgiuk", "aaaaaaaaaaaaaaaaabbbbbbbbbbfasjlcdvacpfeoj", "aaaaaaaaaaaaaaaaabbbbbbbbbbzrlmyegzwztrhgqm", "aaaaaaaaaaaaaaaaabbbbbbbbbbsabrljwjkvad", "aaaaaaaaaaaaaaaaabbbbbbbbbbblgubwcxecfis", "aaaaaaaaaaaaaaaaabbbbbbbbbblilftczybunuobolyt", "aaaaaaaaaaaaaaaaabbbbbbbbbbbppubgbkifd", "aaaaaaaaaaaaaaaaabbbbbbbbbbmobkpochkyoujbhi", "aaaaaaaaaaaaaaaaabbbbbbbbbbvivbqhsnzkkuaw", "aaaaaaaaaaaaaaaaabbbbbbbbbbmdfewpyryuc", "aaaaaaaaaaaaaaaaabbbbbbbbbbwnengvqbcrnqvp", "aaaaaaaaaaaaaaaaabbbbbbbbbbgxpgvmnmmc", "aaaaaaaaaaaaaaaaabbbbbbbbbbipqsetrtzstbxbr", "aaaaaaaaaaaaaaaaabbbbbbbbbbppjuokaakaur", "aaaaaaaaaaaaaaaaabbbbbbbbbbliascfhjkoaoipnjfpza", "aaaaaaaaaaaaaaaaabbbbbbbbbbcurqfbnwaeaecnwbzjxx", "aaaaaaaaaaaaaaaaabbbbbbbbbbwerunjzxrxysrwe", "aaaaaaaaaaaaaaaaabbbbbbbbbbmgiftahfve", "aaaaaaaaaaaaaaaaabbbbbbbbbbvfilicjzkxjel", "aaaaaaaaaaaaaaaaabbbbbbbbbbtodddhiogutkleg", "aaaaaaaaaaaaaaaaabbbbbbbbbbjpdkecyqjk", "aaaaaaaaaaaaaaaaabbbbbbbbbbxklpodeyvvpormm", "aaaaaaaaaaaaaaaaabbbbbbbbbbepfdtqwxnseptm", "aaaaaaaaaaaaaaaaabbbbbbbbbbipkimfiegpxc", "aaaaaaaaaaaaaaaaabbbbbbbbbbvobtdxwkgmeihlwehyy", "aaaaaaaaaaaaaaaaabbbbbbbbbbdvmonnkdkyareqprlixp", "aaaaaaaaaaaaaaaaabbbbbbbbbbkocjwexxlvlaw", "aaaaaaaaaaaaaaaaabbbbbbbbbbprdbqdxkna", "aaaaaaaaaaaaaaaaabbbbbbbbbbqkgvantcuwhvegiddwwi", "aaaaaaaaaaaaaaaaabbbbbbbbbbdyjysydfihjysnmdrg", "aaaaaaaaaaaaaaaaabbbbbbbbbbvuecaamqmedpjozahb", "aaaaaaaaaaaaaaaaabbbbbbbbbbvgrrtznjnoudzhjlv", "aaaaaaaaaaaaaaaaabbbbbbbbbbzmhztrtxvmgujlix", "aaaaaaaaaaaaaaaaabbbbbbbbbbjnlkcvgqodiaduadrr", "aaaaaaaaaaaaaaaaabbbbbbbbbbhrgfqmhktqld", "aaaaaaaaaaaaaaaaabbbbbbbbbbnznbubvpomh", "aaaaaaaaaaaaaaaaabbbbbbbbbbbjxllcohnworrkccgz", "aaaaaaaaaaaaaaaaabbbbbbbbbbvezvdzhrtiezu", "aaaaaaaaaaaaaaaaabbbbbbbbbblerlstmbmc", "aaaaaaaaaaaaaaaaabbbbbbbbbbeukfebwmqcw", "aaaaaaaaaaaaaaaaabbbbbbbbbbulatiybbzkysaco", "aaaaaaaaaaaaaaaaabbbbbbbbbbcdxksbqede", "aaaaaaaaaaaaaaaaabbbbbbbbbbpqyapdgwlchhsphrje", "aaaaaaaaaaaaaaaaabbbbbbbbbbttvgpfeithql", "aaaaaaaaaaaaaaaaabbbbbbbbbbzexpmlggutgcjkdjkuxk", "aaaaaaaaaaaaaaaaabbbbbbbbbbycmbcitrmyviztp", "aaaaaaaaaaaaaaaaabbbbbbbbbbccybojvvwldhu", "aaaaaaaaaaaaaaaaabbbbbbbbbbtmpojutxufmzmsoktdn", "aaaaaaaaaaaaaaaaabbbbbbbbbbopavgkytqmrdn", "aaaaaaaaaaaaaaaaabbbbbbbbbbttabhxgcyau", "aaaaaaaaaaaaaaaaabbbbbbbbbbtiydxbummwn", "aaaaaaaaaaaaaaaaabbbbbbbbbbytftfezlwtbxwx", "aaaaaaaaaaaaaaaaabbbbbbbbbbbajuqotjrhoukeezls"};
        System.out.println(Arrays.toString(new WordAbbreviation().wordsAbbreviation(input)));

        String[] output = {"a36k", "aaaaaaaaaaaaaaaaabbbbbbbbbbojqbr13d", "aaaaaaaaaaaaaaaaabbbbbbbbbbolhhv13d", "a43h", "a42u", "a37v", "a39y", "aaaaaaaaaaaaaaaaabbbbbbbbbbcnj16k", "a40j", "a41m", "aaaaaaaaaaaaaaaaabbbbbbbbbbsabrlj5d", "a38s", "a43t", "a36d", "a41i", "a39w", "a36c", "a39p", "aaaaaaaaaaaaaaaaabbbbbbbbbbg8c", "a40r", "a37r", "a45a", "a45x", "a40e", "aaaaaaaaaaaaaaaaabbbbbbbbbbmg7e", "a38l", "a40g", "a35k", "a40m", "a39m", "a37c", "a44y", "a45p", "a38w", "a35a", "a45i", "a43g", "a43b", "a42v", "a41x", "a43r", "aaaaaaaaaaaaaaaaabbbbbbbbbbhrgfqm5d", "a36h", "a43z", "aaaaaaaaaaaaaaaaabbbbbbbbbbvezv8u", "aaaaaaaaaaaaaaaaabbbbbbbbbbl8c", "a36w", "a40o", "aaaaaaaaaaaaaaaaabbbbbbbbbbcd7e", "a43e", "a37l", "aaaaaaaaaaaaaaaaabbbbbbbbbbzex16k", "a40p", "aaaaaaaaaaaaaaaaabbbbbbbbbbccyb8u", "a44n", "a38n", "a36u", "a36n", "a39x", "a43s"};
        String[] expect = {"a36k", "aaaaaaaaaaaaaaaaabbbbbbbbbboj16d", "aaaaaaaaaaaaaaaaabbbbbbbbbbol16d", "a43h", "a42u", "a37v", "a39y", "aaaaaaaaaaaaaaaaabbbbbbbbbbc18k", "a40j", "a41m", "aaaaaaaaaaaaaaaaabbbbbbbbbbs10d", "a38s", "a43t", "a36d", "a41i", "a39w", "a36c", "a39p", "aaaaaaaaaaaaaaaaabbbbbbbbbbg8c", "a40r", "a37r", "a45a", "a45x", "a40e", "aaaaaaaaaaaaaaaaabbbbbbbbbbm8e", "a38l", "a40g", "a35k", "a40m", "a39m", "a37c", "a44y", "a45p", "a38w", "a35a", "a45i", "a43g", "a43b", "a42v", "a41x", "a43r", "aaaaaaaaaaaaaaaaabbbbbbbbbbh10d", "a36h", "a43z", "aaaaaaaaaaaaaaaaabbbbbbbbbbv11u", "aaaaaaaaaaaaaaaaabbbbbbbbbbl8c", "a36w", "a40o", "aaaaaaaaaaaaaaaaabbbbbbbbbbc8e", "a43e", "a37l", "aaaaaaaaaaaaaaaaabbbbbbbbbbz18k", "a40p", "aaaaaaaaaaaaaaaaabbbbbbbbbbc11u", "a44n", "a38n", "a36u", "a36n", "a39x", "a43s"};
    }
}

package interviewstyle;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    /**
     * 11/30
     *
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[]sChars = s.toCharArray();
        char[]tChars = t.toCharArray();
        Map<Character, Character> isomorphic = new HashMap<>();

        for (int i = 0; i <= sChars.length - 1; i++) {
            if (isomorphic.containsKey(sChars[i])) {
                if (!isomorphic.get(sChars[i]).equals(tChars[i])) {
                    return false;
                }
            } else {
                if (isomorphic.containsValue(tChars[i])) {
                    return false;
                }

                isomorphic.put(sChars[i], tChars[i]);
            }
        }

        char[] ts = new char[sChars.length];
        for (int i = 0; i <= sChars.length - 1; i++) {
            ts[i] = isomorphic.get(sChars[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicString().isIsomorphic("a`%ii,VEZQc_BSU%ObO5<sX81B/bOw+CNUd#Uav*P!Ax!#>hh,k#b/|>4ixFQZl+l!?bJjakbQbGglEb<g>Hf81m@A9GIvbd]qh?y__t+E(Iyv7zUEfZF{81VaM-0u?]tG=_fFR/XJ=X{-,oRpxE9u*VNYlM",
                "b`%ii-WE[Qc_BSV%OcO5<sX82B/cOw+CNVd#Vbv*P!Bx!#?hh-k#c/|?4ixFQ[l+l!?cJkbkcQcGhlEc<h?Hf82m@B9GIvcd]rh?y__t+E(Iyv7{VEf[F{82WbN/0u?]tG=_fFR/XJ=X{/-oRpxE9u*WNYlN"));
    }
}

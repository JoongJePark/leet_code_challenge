import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int sol = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        Set<Character> set = new HashSet<Character>();

        while (end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end += 1;
                sol = Math.max(end-start, sol);
            } else {
                set.remove(s.charAt(start));
                start += 1;
            }
        }
        return sol;
    }
}

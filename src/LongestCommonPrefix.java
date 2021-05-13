import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return new String();
        }
        Arrays.sort(strs);
        int pointer = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (pointer == 0) {
                return new String();
            }
            for (int j = 0; j < Math.min(pointer, strs[i].length()); j++) {
                if (!(strs[0].charAt(j) == strs[i].charAt(j))) {
                    pointer = j;
                    break;
                }

            }
        }
        return strs[0].substring(0, pointer);
    }
}

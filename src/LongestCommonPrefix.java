import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return new String();
        }
        int pointer = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (pointer == 0) {
                return new String();
            }
            pointer = Math.min(pointer, strs[i].length());
            for (int j = 0; j < pointer; j++) {
                if (!(strs[0].charAt(j) == strs[i].charAt(j))) {
                    pointer = j;
                    break;
                }

            }
        }
        return strs[0].substring(0, pointer);
    }
}

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int pointer = 0;
        Loop1:
        while (pointer < s.length()) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '.' && i < p.length() - 1 && p.charAt(i + 1) == '*') {
                    return true;
                } else if (p.charAt(i) == '.' && i < p.length() - 1 && p.charAt(i + 1) != '*') {
                    pointer += 1;
                    i += 1;
                    continue;
                } else if (p.charAt(i) == '.' && i == p.length() - 1) {
                    pointer += 1;
                    break Loop1;
                }
                if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
                    while (pointer<s.length() && s.charAt(pointer) == p.charAt(i) ) {
                        pointer += 1;
                    }
                    if(i==p.length()-2){
                        break Loop1;
                    }
                    i += 1;
                } else if (i < p.length() - 1 && p.charAt(i + 1) != '*') {
                    if (s.charAt(pointer) == p.charAt(i)) {
                        pointer += 1;
                    }
                } else if (i == p.length() - 1) {
                    pointer += 1;
                    break Loop1;
                }
            }
        }
        return pointer == s.length();
    }
}

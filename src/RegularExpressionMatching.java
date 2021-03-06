public class RegularExpressionMatching {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        if (text.isEmpty()) {
            return pattern.length() >= 2 && pattern.charAt(1) == '*' && isMatch(text, pattern.substring(2));
        }
        boolean checkFirst = (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (checkFirst && isMatch(text.substring(1), pattern));
        }
        return checkFirst && isMatch(text.substring(1), pattern.substring(1));
    }
}

//test
//test2
//leetcode solution
//class Solution {
//    public boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }
//}

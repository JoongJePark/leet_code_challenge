public class LongestPalindromicSubstring {
    int solLength;
    String sol = "";

    public void test(int start, int end, String s) {
        boolean result = false;
        if (s.charAt(start) == s.charAt(end - 1)) {
            result = true;
        }
        if (result) {
            if (solLength < end - start) {
                sol = s.substring(start, end);
                solLength = end - start;
            }
            if (start > 0 && end < s.length()) {
                test(start - 1, end + 1, s);
            }
        }
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            test(i, i + 1, s);
        }
        for (int i = 0; i < n - 1; i++) {
            test(i, i + 2, s);
        }
        return sol;
    }
}

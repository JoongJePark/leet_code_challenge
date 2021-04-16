public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int sol=0;
        char[] arr = new char[s.length()];
        for (int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i);
        }
        return sol;
    }
}

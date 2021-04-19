import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int sol = 0;
        int index = 0;
        int n = s.length();
//        HashMap<Integer, Character> map = new HashMap<Integer, Character>(n);
//        for (int i = 0; i<n; i++){
//            map.put(i,s.charAt(i));
//        }
        for (int i=0; i<n; i++){
            for (int j =i+1; j<n; j++){
                if(s.charAt(i)==s.charAt(j)){
                    index = j-i;
                    break;
                }
            }
            if(index==0){
                index = n-i;
            }
            sol = Math.max(sol, index);
        }

        return sol;
    }
}

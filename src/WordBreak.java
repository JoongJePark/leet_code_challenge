import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] boolArr = new boolean[n + 1];
        for (String word : wordDict) {
            if (s.length() >= word.length() && word.equals(s.substring(0, word.length()))) {
                boolArr[word.length()] = true;
            }
        }
        for (int k = 1; k < n + 1; k++) {
            for (String word : wordDict) {
                if (k >= word.length() && word.equals(s.substring(k - word.length(), k))) {
                    boolArr[k] = boolArr[k] || boolArr[k - word.length()];
                }
            }
        }
        return boolArr[n];
    }
}

//TODO: 2ms solution
//class Solution {
//
//    Map<String, Boolean> map = new HashMap<String,Boolean>();
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        if(s.length() == 0) return true;
//
//        if(map.containsKey(s) && !map.get(s)) return false;
//        for(String str:wordDict){
//
//            int len = str.length();
//
//            if(s.indexOf(str) == 0){
//
//                if(wordBreak(s.substring(len),wordDict)){
//                    return true;
//                }
//            }
//
//
//        }
//        map.put(s,false);
//        return false;
//    }
//}
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        if (strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String keyString = String.valueOf(charArr);
            if (map.containsKey(keyString)) {
                map.get(keyString).add(str);
            } else {
                map.put(keyString, new ArrayList<>());
                map.get(keyString).add(str);
            }
        }
        for (String key : map.keySet()) {
            sol.add(map.get(key));
        }
        return sol;
//        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
//        HashMap<String, List<String>> map2 = new HashMap<>();
//        boolean overlap = true;
//        if (strs.length < 1) {
//            return sol;
//        }
//        Loop1:
//        for (int i = 0; i < strs.length; i++) {
//            HashMap<Character, Integer> input = new HashMap<>();
//            for (int j = 0; j < strs[i].length(); j++) {
//                if (input.containsKey(strs[i].charAt(j))) {
//                    int nOfChar = input.get(strs[i].charAt(j)) + 1;
//                    input.put(strs[i].charAt(j), nOfChar);
//                } else {
//                    input.put(strs[i].charAt(j), 1);
//                }
//            }
//            Loop2:
//            for (String key : map.keySet()) {
//                for (Character key2 : map.get(key).keySet()) {
//                    if (!input.containsKey(key2) || !(input.get(key2).equals(map.get(key).get(key2)))) {
//                        continue Loop2;
//                    }
//                }
//                if (strs[i].length() == key.length()) {
//                    map2.get(key).add(strs[i]);
//                    continue Loop1;
//                }
//            }
//            map2.put(strs[i], new ArrayList<>(Arrays.asList(strs[i])));
//            map.put(strs[i], input);
//        }
//        for (String key : map2.keySet()) {
//            sol.add(map2.get(key));
//        }
//        return sol;
    }
}

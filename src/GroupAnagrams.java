import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        HashMap<String, HashSet<Character>> map = new HashMap<>();
        HashMap<String, List<String>> map2 = new HashMap<>();
        boolean overlap = true;
        if(strs.length < 1){
            return sol;
        }
        HashSet<Character> firstInput = new HashSet<>();
        for(int i=0; i<strs[0].length(); i++){
            firstInput.add(strs[0].charAt(i));
        }
        map.put(strs[0], firstInput);
        map2.put(strs[0], new ArrayList<>(Arrays.asList(strs[0])));
        HashSet<Character> input = new HashSet<>();
        for (int i = 1; i < strs.length; i++) {
            for (String key : map.keySet()) {
                for (int j = 0; j < strs[i].length(); j++) {
                    overlap &= map.get(key).contains(strs[i].charAt(j));
                    input.add(strs[i].charAt(j));
                }
                if (overlap && strs[i].length() == key.length()) {
                    map2.get(key).add(strs[i]);
                } else {
                    map2.put(strs[i], new ArrayList<>(Arrays.asList(strs[i])));
                    map.put(strs[i], input);
                    input.clear();
                    overlap = true;
                    break;
                }
                input.clear();
                overlap = true;
            }
        }
        for (String key : map2.keySet()) {
            sol.add(map2.get(key));
        }
        return sol;
    }
}

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        int count = 0;
        HashSet<String> set = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            count++;
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                String s = queue.poll();
                if (s.equals(endWord))
                    return count;
                queue.addAll(findChildrens(s, set));
            }
        }

        return 0;
    }

    private List<String> findChildrens(String s, HashSet<String> set) {
        List<String> neighbours = new ArrayList<String>();
        char[] parent = s.toCharArray();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < parent.length; i++) {
                char old = parent[i];
                parent[i] = c;
                String checkWord = String.valueOf(parent);
                if (set.contains(checkWord)) {
                    neighbours.add(checkWord);
                    set.remove(checkWord);
                }
                parent[i] = old;
            }
        }
        return neighbours;
    }
}

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] mergeAll(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] > list.get(j)[1]) {
                    list.remove(list.get(j));
                } else if (list.get(j)[0] < list.get(i)[0] && list.get(j)[1] > list.get(i)[1]) {
                    list.remove(list.get(i));
                } else if (list.get(i)[1] < list.get(j)[0] || list.get(j)[1] < list.get(i)[0]) {
                    List<int[]> sol = new ArrayList<>();
                    sol.add([Math.min(list.get(i)[0], list.get(j)[0]), Math.max(list.get(i)[1], list.get(j)[1])]);
                    list.remove(list.get(j));
                    list.remove(list.get(i));
                    list.add()
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

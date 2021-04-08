import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] mergeAll(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        Loop1:
        for (int i = 0; i < list.size(); i++) {
            Loop2:
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i)[0] <= list.get(j)[0] && list.get(i)[1] >= list.get(j)[1]) {
                    list.remove(list.get(j));
                    j = j - 1;
                } else if (list.get(j)[0] <= list.get(i)[0] && list.get(j)[1] >= list.get(i)[1]) {
                    list.remove(list.get(i));
                    i = i - 1;
                    break Loop2;

                } else if ((list.get(i)[1] >= list.get(j)[0] && list.get(i)[0] < list.get(j)[0])) {
                    //List<int[]> sol = new ArrayList<>();
                    int[] arr = new int[2];
                    arr[0] = Math.min(list.get(i)[0], list.get(j)[0]);
                    arr[1] = Math.max(list.get(i)[1], list.get(j)[1]);
                    System.out.println(Arrays.toString(list.get(i)));
                    System.out.println(Arrays.toString(list.get(j)));
                    System.out.println(Arrays.toString(arr));
                    list.remove(list.get(j));
                    list.remove(list.get(i));
                    list.add(i, arr);
                    i = i - 1;
                    break Loop2;
                } else if ((list.get(j)[1] >= list.get(i)[0] && list.get(j)[0] < list.get(i)[0])) {

                }
            }
        }
        int[][] real_sol = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            real_sol[i][0] = list.get(i)[0];
            real_sol[i][1] = list.get(i)[1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< real_sol.length; i++){
            sb.append(Arrays.toString(real_sol[i]));
        }
        System.out.println(sb);
        return real_sol;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] input = new int[4][2];
        input[0][0] = 1;
        input[0][1] = 3;
        input[1][0] = 2;
        input[1][1] = 6;
        input[2][0] = 8;
        input[2][1] = 10;
        input[3][0] = 15;
        input[3][1] = 18;
        mergeIntervals.mergeAll(input);
    }
}

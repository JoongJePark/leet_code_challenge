import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> solList = new LinkedList<int[]>();
        for(int[] interval:intervals) {
            if(solList.isEmpty() || solList.getLast()[1]<interval[0]) {
                solList.add(interval);
            } else if(solList.getLast()[1]>=interval[0] && interval[1] > solList.getLast()[1]){
                int[] arr = new int[2];
                arr[0] = solList.getLast()[0];
                arr[1] = interval[1];
                solList.set(solList.size()-1, arr);
            }
        }
        int[][] sol = solList.toArray(new int[solList.size()][2]);
        return sol;
    }
}

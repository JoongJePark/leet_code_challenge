import java.util.Arrays;

public class MeetingRooms2 {
    public int myCompare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }
        return Integer.compare(a[1], b[1]);
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int sol =0;
        int end = 0;
        boolean[] check = new boolean[n];
        for(int i =0; i<n; i++){
            if(check[i]){
                continue;
            } else {
                check[i] = true;
                end = intervals[i][1];
            }
            for(int j=i+1; j<n; j++){
                if(check[j]){
                    continue;
                }
                if(end<=intervals[j][0]){
                    check[j] = true;
                    end = intervals[j][1];
                }
            }
            sol += 1;
        }
        return sol;
    }
}

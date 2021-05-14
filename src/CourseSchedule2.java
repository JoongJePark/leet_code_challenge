import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> sol = new ArrayList<>(numCourses);
        for (int i=0; i<numCourses; i++){
            sol.add(i);
        }
        HashSet<int[]> set = new HashSet<>();
        for (int[] pre : prerequisites) {
            set.add(pre);
        }
        Collections.sort(sol, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(set.contains(new int[] {a,b})){
                    return -1;
                } else if(set.contains(new int[] {b,a})){
                    return 1;
                }
                return a-b;
            }
        });
        System.out.println(set);
        int[] realSol = sol.stream().mapToInt(i->i).toArray();
        return realSol;
    }
}

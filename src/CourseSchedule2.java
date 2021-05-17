import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] sol = new int [numCourses];
        int size = 0;
        List<List<Integer>> myList = new ArrayList<>(numCourses);
        int index;
        int[] degree = new int[numCourses];
        boolean[] check = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            myList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            myList.get(pre[0]).add(pre[1]);
            degree[pre[0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();

        while (size < numCourses) {
            index = -1;
            for (int i = 0; i < numCourses; i++) {
                if (!check[i] && degree[i] == 0) {
                    queue.add(i);
                    check[i] = true;
                    index=i;
                }
            }
            if(index == -1 ) {
                return new int[0];
            }
            while (!queue.isEmpty()) {
                int a = queue.poll();
                sol[size] = a;
                size++;
                for (int j = 0; j < myList.size(); j++) {
                    if (myList.get(j).contains(a)){
                        degree[j] -= 1;
                    }
                }
            }
        }
        return sol;
    }
}

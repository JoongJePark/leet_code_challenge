import java.util.*;

class TrappingRainWater1 {
    public int trap(int[] height) {
        int length = height.length;
        if(length==0){
            return 0;
        }
        if(length==1){
            return 0;
        }
        int sameHeightLength = 0;
        int sol = 0;
        ArrayList<Integer> sameHeight = new ArrayList<Integer>();
        ArrayList<Integer> localMax = new ArrayList<Integer>();
        sameHeight.add(0);
        for (int i = 0; i < length - 1; i++) {
            if (!(height[i] == height[i + 1])) {
                sameHeight.add(i + 1);
            }
        }
        sameHeightLength = sameHeight.size();
        if (height[sameHeight.get(0)] > height[sameHeight.get(1)]) {
            localMax.add(sameHeight.get(0));
        }
        for (int i = 1; i < sameHeightLength - 1; i++) {
            if (height[sameHeight.get(i - 1)] < height[sameHeight.get(i)] & height[sameHeight.get(i)] > height[sameHeight.get(i + 1)]) {
                localMax.add(sameHeight.get(i));
            }
        }
        if (height[sameHeight.get(sameHeightLength - 1)] > height[sameHeight.get(sameHeightLength - 2)]) {
            localMax.add(sameHeight.get(sameHeightLength - 1));
        }
        int localMaxLength = localMax.size();
        int max = height[localMax.get(0)];
        System.out.println(localMax);

        for (int i = 1; i < localMaxLength; i++) {
//            System.out.println(height[localMax.get(i)]);
            if (max > height[localMax.get(i)]) {
                for (int j = i; j < localMaxLength; j++) {
                    System.out.println(j);
                    if (height[localMax.get(j)] > height[localMax.get(i)]) {
                        localMax.remove(Integer.valueOf(localMax.get(i)));
                        i = i-1;
                        localMaxLength= localMaxLength-1;
                        break;
                    }
                }
            } else {
                max = height[localMax.get(i)];
            }
        }
        System.out.println(localMax);

        for (int i = 0; i < localMaxLength - 1; i++) {
            for (int j = localMax.get(i); j < localMax.get(i + 1); j++) {
                sol += Math.max(0, (Math.min(height[localMax.get(i)], height[localMax.get(i + 1)]) - height[j]));
            }
        }
        System.out.println(sol);
        return sol;
    }

    public static void main(String[] args) {
        TrappingRainWater1 solution = new TrappingRainWater1();
        int[] a = new int[10];
        a[0] = 5;
        a[1] = 5;
        a[2] = 1;
        a[3] = 7;
        a[4] = 1;
        a[5] = 1;
        a[6] = 5;
        a[7] = 2;
        a[8] = 7;
        a[9] = 6;

        solution.trap(a);
    }
}

public class MaximumSubArray {
    //    public int maxSubArray(int[] nums) {
//        int sol = Integer.MIN_VALUE;
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        int n = nums.length;
//        for (int i=0; i<n; i++){
//            max = Math.max(nums[i], max);
//        }
//        if(max<=0){
//            return max;
//        }
//        for (int k = 0; k < n; k++) {
//            for (int i = 0; i < n - k; i++) {
//                if (nums[i] > 0) {
//                    sum = 0;
//                    for (int j = i; j < j + k + 1 && j + k + 1 <= n; j++) {
//                        sum += nums[j];
//                    }
//                    sol = Math.max(sum, sol);
//                }
//            }
//        }
//        return sol;
//    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] maxSubArray = new int[n];
        maxSubArray[0] = nums[0];
        int max = maxSubArray[0];

        for (int i = 1; i < n; i++) {
            maxSubArray[i] = nums[i] + (maxSubArray[i - 1] > 0 ? maxSubArray[i - 1] : 0);
            max = Math.max(max, maxSubArray[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}

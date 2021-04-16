public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int nOfZero = 0;
        int product = 1;
        int[] answer = new int[n];
        int index =0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nOfZero += 1;
                index = i;
                continue;
            }
            product = product * nums[i];
        }
        if (nOfZero >1){
            return answer;
        }
        if (nOfZero == 1 ){
            answer[index] = product;
            return answer;
        }
        for (int i =0; i<n; i++){
            answer[i] = product / nums[i];
        }
        return answer;
    }

//    예시답안, 여기서는 나누기 대신 양쪽에서의 곱하기로 구현
//    public int[] productExceptSelf(int[] nums) {
//        int[] res = new int[nums.length];
//
//        res[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            res[i] = res[i-1] * nums[i-1];
//        }
//
//        int runningR = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            res[i] = res[i] * runningR;
//            runningR *= nums[i];
//        }
//
//        return res;
//    }
}

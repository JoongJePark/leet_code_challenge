public class DecodeWays {
    public int numDecodings(String s) {
        //첫자리 0인경우 0
        //첫자리 3-9인경우 한자리 빼고 계산한 값과 같음
        //첫자리 1인경우 다음 자리가 0인경우 두자리 빼고 계산과 같음
        //             다음 자리가 1-9 인경우 한자리 빼고 계산 값과 두자리 빼고 계산값 합과 같음
        //첫자리 2인경우 다음 자리가 0인경우 두자리 빼고 계산과 같음
        //             다음 자리가 1-6인경우 한자리 빼고 계산 값과 두자리 빼고 계산값 합과 같음
        //             다음 자리가 7-9인경우 두자리 빼고 계산과 같음
        int n = s.length();
        if (s.length()==0){
            return 0;
        }
        int[] memo = new int[n+1];
        memo[n] =1;
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                memo[i] = 0;
            } else {
                memo[i]=memo[i+1];
                if(((i+1 < n) && s.charAt(i)=='1') || ((i+1 < n) && s.charAt(i) == '2' && s.charAt(i+1)<='6')){
                    memo[i] += memo[i+2];
                }
            }

        }
        return memo[0];

//        if (s.equals("")) {
//            return 0;
//        }
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        if (s.length() == 1) {
//            if ('1' <= s.charAt(0) && s.charAt(0) <= '9') {
//                return 1;
//            }
//        }
//        if (s.length() == 2) {
//            if ('1' == s.charAt(0)) {
//                if ('1' <= s.charAt(1) && s.charAt(1) <= '9') {
//                    return 2;
//                } else if ('0' == s.charAt(1)) {
//                    return 1;
//                }
//            }
//            if ('2' == s.charAt(0)) {
//                if ('1' <= s.charAt(1) && s.charAt(1) <= '6') {
//                    return 2;
//                } else if ('7' <= s.charAt(1) && s.charAt(1) <= '9') {
//                    return 1;
//                } else if ('0' == s.charAt(1)) {
//                    return 1;
//                }
//            }
//        }
//        if (s.charAt(0) == '0') {
//            return 0;
//        } else if ('3' <= s.charAt(0) && s.charAt(0) <= '9') {
//            return numDecodings(s.substring(1));
//        } else if (s.charAt(0) == '1') {
//            if (s.substring(1).charAt(0) == '0') {
//                return numDecodings(s.substring(2));
//            } else {
//                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
//            }
//        } else if (s.charAt(0) == '2') {
//            if (s.substring(1).charAt(0) == '0') {
//                return numDecodings(s.substring(2));
//            } else if ('1' <= s.substring(1).charAt(0) && s.substring(1).charAt(0) <= '6') {
//                return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
//            } else if ('7' <= s.substring(1).charAt(0) && s.substring(1).charAt(0) <= '9') {
//                return numDecodings(s.substring(2));
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {

    }
}

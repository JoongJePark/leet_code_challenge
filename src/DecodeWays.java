public class DecodeWays {
    public int numDecodings(String s) {
        //첫자리 0인경우 0
        //첫자리 3-9인경우 한자리 빼고 계산한 값과 같음
        //첫자리 1인경우 다음 자리가 0인경우 두자리 빼고 계산과 같음
        //             다음 자리가 1-9 인경우 한자리 빼고 계산 값과 두자리 빼고 계산값 합과 같음
        //첫자리 2인경우 다음 자리가 0인경우 두자리 빼고 계산과 같음
        //             다음 자리가 1-6인경우 한자리 빼고 계산 값과 두자리 빼고 계산값 합과 같음
        //             다음 자리가 7-9인경우 두자리 빼고 계산과 같음
        return 0;
    }
    public static void main(String[] args) {

    }
}

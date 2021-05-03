public class ReverseInteger {
    public int reverse(int x) {
        if (x==Integer.MIN_VALUE){
            return 0;
        }
        if (Math.abs(x) >= Integer.MAX_VALUE){
            return 0;
        }
        int length = 0;
        int sol = 0;
        int test = x;
        while(Math.abs(test)>=10){
            length += 1;
            test= test/10;
        }
        while(Math.abs(x)>=10){
            int res = x%10;
            x = x/10;
            sol += res*Math.pow(10, length);
            length -= 1;
        }
        sol += x*Math.pow(10, length);
        if (Math.abs(sol) >= Integer.MAX_VALUE){
            return 0;
        }
        if (sol==Integer.MIN_VALUE){
            return 0;
        }
        return sol;
    }
}

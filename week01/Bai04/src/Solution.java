public class Solution {
    public long fibonacci(long n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long a = 0;
            long b = 1;
            long ans = 1;
            for (long i = 2; i <= n; i++) {
                if (Long.MAX_VALUE - b < a) {
                    return Long.MAX_VALUE;
                }
                ans = a + b;
                a = b;
                b = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long test[] = {0,1,9,10,95,-1};
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.fibonacci(test[i]));
        }
    }
}
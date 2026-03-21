public class Solution {
    public int reverse(int n) {
        long ans = 0;
        while (n != 0) {
            int tmp = n%10;
            ans = ans*10 + tmp;
            n = n/10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {123,-123,120,0,1534236469,900000};
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.reverse(test[i]));

        }
    }
}
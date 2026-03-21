public class Solution {
    public int reverse (int n) {
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

    public boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        if (reverse(n) == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] test = {121,-121,10,0,7,12321,123456,2147483647};
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.isPalindrome(test[i]));
        }
    }
}
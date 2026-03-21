public class Solution {
    public int sumOfDigits(int n) {
        //if (n < 0) {
        //    n = -1 * n;
        //}
        int cnt = 0;
        while (n != 0) {
            int tmp = n % 10;
            if (tmp < 0) {
                tmp = -tmp;
            }
            cnt += tmp;
            n = n / 10;
        }
        return cnt;
    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        int n = -2147483648;
        int[] test = {1234,-12901,15000,0,2147483647,-2147483648};
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.sumOfDigits(test[i]));
        }
    }
}

public class Solution {
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {-7,-1,0,1,2,3,4,15,17,97,100};
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.isPrime(test[i]));
        }
    }
}
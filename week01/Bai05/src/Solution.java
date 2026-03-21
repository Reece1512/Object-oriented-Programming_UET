public class Solution {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a <= 0) {
            a = -1*a;
        }
        if (b <= 0) {
            b = -1*b;
        }
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = {
                {12, 18},
                {7, 13},
                {0, 5},
                {0, 0},
                {-12, 18},
                {100, 10}
        };
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.gcd(test[i][0], test[i][1]));
        }
    }
}
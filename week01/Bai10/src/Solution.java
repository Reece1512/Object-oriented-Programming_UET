public class Solution {
    public int secondLargest(int[] arr) {
        int maxx = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxx && maxx == Integer.MIN_VALUE) {
                maxx = arr[i];
            } else if (arr[i] > maxx && maxx != Integer.MIN_VALUE) {
                max2 = maxx;
                maxx = arr[i];
            } else if (arr[i] < maxx && arr[i] > max2) {
                max2 = arr[i];
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max2 && arr[i] < maxx) {
//                max2 = arr[i];
//            }
//        }
        if (max2 == Integer.MIN_VALUE) {
            return -1;
        } else {
            return max2;
        }

    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        int[][] test = {
                {1, 2, 3, 4, 6, 6},
                {10, 10, 10},
                {5, 2},
                {5},
                {-5, -10, -2, -8},
                {1, 5, 5, 2, 4}
        };
        for (int i = 0; i<test.length; i++) {
            System.out.println(sol.secondLargest(test[i]));
        }
    }
}

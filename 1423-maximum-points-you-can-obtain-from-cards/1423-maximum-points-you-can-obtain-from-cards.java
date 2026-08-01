class Solution {
    public int maxScore(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;

        // Take first k cards from the left
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        if (k == n) {
            return sum;
        }

        ans = sum;

        // Replace left cards with right cards one by one
        for (int i = k - 1; i >= 0; i--) {
            sum -= nums[i];
            sum += nums[n - k + i];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
class Solution {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (k == 0) {
                candidate = nums[i];
            }

            if (nums[i] == candidate) {
                k++;
            } else {
                k--;
            }
        }

        return candidate;
    }
}
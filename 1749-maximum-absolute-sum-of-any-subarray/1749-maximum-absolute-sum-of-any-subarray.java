class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int curr=nums[0];
        int max = nums[0];
        int minend=nums[0];
        int minsum=nums[0];

        for(int i =1;i<nums.length;i++){

           curr=Math.max(nums[i],curr+nums[i]);
           max = Math.max(curr, max);
           minend = Math.min(nums[i], minend + nums[i]);
           minsum=Math.min(minend,minsum);
           }

        return Math.max(max, Math.abs(minsum));
        
    }
}
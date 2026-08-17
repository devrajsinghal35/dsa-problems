class Solution {
    public int maxProduct(int[] nums) {
       int min=nums[0];
       int max=nums[0];
       int result =nums[0];
        for(int i=1 ;i<nums.length; i++){
        int oldmin=min;
        int oldmax=max;
        int a= oldmin*nums[i];
        int b = oldmax*nums[i];
        int c = nums[i];

        max= Math.max(a,Math.max( b, c));
        min=Math.min( a, Math.min(b, c));
        result= Math.max(min,Math.max(max,result));

       }
       return result ;
        
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int target = 0;
        // Arrays.sort(nums);
        // Set<List<Integer>> s = new HashSet<>();
        // List<List<Integer>> output = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++){
        //     int j = i + 1;
        //     int k = nums.length - 1;
        //     while (j < k) {
        //         int sum = nums[i] + nums[j] + nums[k];
        //         if (sum == target) {
        //             s.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             j++;
        //             k--;
        //         } else if (sum < target) {
        //             j++;
        //         } else {
        //             k--;
        //         }
        //     }
        // }
        // output.addAll(s);
        // return output;

        // int n = nums.length;
        // Set<List<Integer>> st = new HashSet<>();
        // for(int i = 0; i < n; i++){
        //     Set<Integer>hs = new HashSet<>();
        //     for(int j = i + 1; j < n; j++){
        //         int third = -(nums[i] + nums[j]);
        //         if(hs.contains(third)){
        //             List<Integer>ls = Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(ls);
        //             st.add(ls);
        //         }
        //         hs.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(st);


        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>>st = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    st.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return st;
    }
}
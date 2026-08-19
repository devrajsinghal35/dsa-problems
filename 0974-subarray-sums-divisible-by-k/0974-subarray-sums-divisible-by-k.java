class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefix=0;
        int count =0;
        HashMap<Integer,Integer> prefixMap=new HashMap<>();
        prefixMap.put(0,1);
        for (int num : nums) {
            prefix += num;
            int mod = prefix % k;
            if (mod < 0) {
                mod += k;
            }
            if (prefixMap.containsKey(mod)) {
                count += prefixMap.get(mod);
                prefixMap.put(mod, prefixMap.get(mod) + 1);
            } else {
                prefixMap.put(mod, 1);
            }
        }
        
        return count;
    }}


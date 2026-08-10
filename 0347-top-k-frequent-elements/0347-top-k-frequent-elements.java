import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        List<int[]> list = new ArrayList<>();

        for (int num : map.keySet()) {
            list.add(new int[]{map.get(num), num});
        }

        // 3. Sort by frequency
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        // 4. Create answer
        int[] ans = new int[k];

        // 5. Take from the end
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(list.size() - 1 - i)[1];
        }

        // 6. Return answer
        return ans;
    }
}
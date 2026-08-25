class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pointer = m;

        for (int i = 0; i < n; i++) {
            nums1[pointer] = nums2[i];
            pointer++;
        }

        Arrays.sort(nums1);
    }
}
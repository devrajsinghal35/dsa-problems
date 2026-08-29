class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] have = new int[128];

        // Store required characters
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            have[c]++;

            // We collected a required character
            if (have[c] <= need[c]) {
                count++;
            }

            // Window contains all characters of t
            while (count == t.length()) {

                // Update minimum answer
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                have[leftChar]--;

                if (have[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Count characters of p
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pCount, windowCount)) {
            ans.add(0);
        }

        // Slide the window
        for (int right = p.length(); right < s.length(); right++) {

            // Add right character
            windowCount[s.charAt(right) - 'a']++;

            // Remove left character
            int left = right - p.length();
            windowCount[s.charAt(left) - 'a']--;

            // Check if current window is an anagram
            if (Arrays.equals(pCount, windowCount)) {
                ans.add(left + 1);
            }
        }

        return ans;
    }
}
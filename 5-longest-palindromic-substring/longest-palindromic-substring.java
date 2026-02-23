class Solution {
    public String longestPalindrome(String s) {
        // Step 1: Transform
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        String t = sb.toString();
        int n = t.length();

        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLen = 0, maxCenter = 0;

        // Step 2: Manacher
        for (int i = 0; i < n; i++) {
            // Mirror use karo agar boundary ke andar ho
            if (i < right) {
                int mirror = 2 * center - i;
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around i
            int l = i - (p[i] + 1);
            int r = i + (p[i] + 1);
            while (l >= 0 && r < n && t.charAt(l) == t.charAt(r)) {
                p[i]++;
                l--;
                r++;
            }

            // Update center aur right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Track longest
            if (p[i] > maxLen) {
                maxLen = p[i];
                maxCenter = i;
            }
        }

        // Step 3: Original string mein convert karo
        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
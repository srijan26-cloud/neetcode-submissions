class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lastSeen[] = new int[128];
        int maxLen = 0;
        int left = 0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            left= Math.max(left, lastSeen[ch]);
            maxLen = Math.max(maxLen, r-left+1);
            lastSeen[ch] = r+1;
        }
        return maxLen;
    }
}

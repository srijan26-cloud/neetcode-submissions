class Solution {
    public int lengthOfLongestSubstring(String s) {
        //brute force
        if(s.length() == 1)
            return 1;
        int n= s.length();
        int maxLen =0;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(hasUniqueChar(s,i,j)){
                    maxLen = Math.max(maxLen , j-i+1);
                }
            }
        }
        return maxLen;
    }
    private boolean hasUniqueChar(String s, int start, int end){
        boolean visited[] = new boolean[128];
        for(int i=start;i<=end;i++){
            char ch = s.charAt(i);
            if(visited[ch])
                return false;
            visited[ch] = true;
        }
        return true;
    }
}

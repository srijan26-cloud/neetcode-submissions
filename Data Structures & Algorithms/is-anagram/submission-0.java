class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int s1[] = new int[26];
        for(char c : s.toCharArray()){
            s1[(int)c-'a']++;
        }
        for(char x : t.toCharArray()){
            s1[(int)x-'a']--;
        }
        for(int i=0;i<26;i++){
            if(s1[i] != 0)
                return false;
        }
        return true;
    }
}

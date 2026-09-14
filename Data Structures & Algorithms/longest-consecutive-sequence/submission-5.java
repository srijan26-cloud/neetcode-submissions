class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int max = 0;
        for(int n : set){
            //only attempt to build if n is the starting point
            if(!set.contains(n-1)){
                int currNum = n;
                int currStreak = 1;
                while(set.contains(currNum + 1)){
                    currNum += 1;
                    currStreak ++;
                }
                max = Math.max(max , currStreak);
            }
        }
        return max;
    }
}

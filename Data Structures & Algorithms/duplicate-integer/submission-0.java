class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                return true;
            }
            else
                map.put(n,1);
        }
        return false;
    }
}
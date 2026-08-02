class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int n : map.keySet()){
            q.offer(n);
            if(q.size() > k)
                q.poll();
        }

        int res[] = new int[k];
        for(int i=0;i<k;i++)
            res[i] = q.poll();

        return res;  
        
        }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r){
            int mid = l + (r-l) /2;
            long hrNeeded= 0;
            for(int p : piles){
                hrNeeded += (p + mid -1L)/mid;
            }
            if(hrNeeded <= h){
                res = mid;
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}

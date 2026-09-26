class Solution {
    private static int findPivot(int[] nums, int len){
        int l=0, r = len-1;
        while(l<r){
            int mid = l + (r-l)/2;

            if(nums[mid] > nums[r]){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return r;
    }

    private static int binarySearch(int[] nums, int l, int r, int t){
        while(l <= r){
            int mid = l+ (r-l)/2;
            if(nums[mid] == t)
                return mid;
            else if(nums[mid] < t)
                l= mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        //find pivot point where left becomes greater than right.
        //separates the two sorted array
        int pivot = findPivot(nums, nums.length);

        int findRes = -1;
        findRes = binarySearch(nums, 0, pivot-1, target);

        if(findRes != -1)
            return findRes;
        findRes = binarySearch(nums , pivot , nums.length-1, target);

        return findRes;
    }
}

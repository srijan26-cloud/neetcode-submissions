class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //swap the param so that 1st param is shortest
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int m= nums1.length;
        int n= nums2.length;

        int l=0;
        int r=m;
    
        while(l <= r){

            int Px = l+(r-l)/2;//mid - in nums1
            int Py = (m+n+1)/2 -Px;//nums2

            //left half combine nums1 & nums2 
            //(len of nums1 or nums2 taken as Px/Py could be 0)
            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px-1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];

            //right half combine nums1 & nums2 
            //(len of nums1 or nums2 taken as Px/Py could be full len)
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];
            
            // check the cross values 
            //left half of nums1 <= right half of nums2 and,
            //left half of nums2 <= right half of nums1
            if(x1 <= x4 && x2 <= x3){
                //if total nums1 + nums2 size is odd, then 
                // find the max of left half nums1 & nums2 edges
                if((m+n)%2 == 1)
                    return Math.max(x1,x2);
                else
                    //find max from left half (edge1) and
                    //find min from right half (edge2) 
                    //and take their avg as answer
                    return (Math.max(x1,x2) + Math.min(x3,x4))/2.0;
            }
            //check if edge if nums1 in left is greater than nums2 in right then 
            //remove elements from the nums1 in left
            else if (x1 > x4)
                r = Px-1;
            else
                l = Px+1;

        }
        return -1;
    }
}

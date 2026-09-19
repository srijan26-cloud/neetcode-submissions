class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if(n == 0)
            return 0;

        int car[][] = new int[n][2];

        for(int i=0;i<n;i++){
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        // sort in asce order by position 
        Arrays.sort(car, (a,b) -> Integer.compare(a[0], b[0]));

        Stack<Double> st = new Stack<>();
        for(int i=n-1;i>= 0;i--){
            double currTime = (double)(target - car[i][0]) / car[i][1];
            // is faster or jopins the fleet 
            if(!st.isEmpty() && currTime <= st.peek())
                continue;
            st.push(currTime);
        }
        return st.size();
    }
}

class TimeMap {
    private class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Pair>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key , new ArrayList<>());
        mp.get(key).add(new Pair(value, timestamp));
    }
    
    private static String binarySearch(List<Pair> list, int l, int r, int timestamp){
        String res ="";
        while(l <= r){
            int mid = l +(r-l)/2;
            if(list.get(mid).timestamp <= timestamp){
                res= list.get(mid).value;//could be one res
                l = mid+1;
            }
            else
                r= mid-1;
        }
        return res;
    }
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key))
            return "";
        List<Pair> list = mp.get(key);
        return binarySearch(list, 0, list.size()-1, timestamp);
    }
}

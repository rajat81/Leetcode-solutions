class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[1]-b[1]);
        // sort using the end times
        TreeMap<Integer, Long> profit = new TreeMap<>(); 
        profit.put(0, 0L);
        
        for(int[] p: rides) {
            long current = p[1]-p[0]+p[2] + profit.floorEntry(p[0]).getValue();
            if(current >= profit.lastEntry().getValue()) {
                profit.put(p[1], current);
            }
                
            
        }
        
        return profit.lastEntry().getValue();
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <2) return intervals;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        
        int[] curr = intervals[0];  // curr -> 1 3
        ans.add(curr);
        
        for(int[] p:intervals) {        // 1 3
            if(p[0] <= curr[1]) {   
                // overlappping
                curr[1] = Integer.max(curr[1], p[1]); 
            } else {
                // not overlapping
                curr = p;
                ans.add(curr);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}


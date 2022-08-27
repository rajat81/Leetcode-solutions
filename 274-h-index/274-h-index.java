class Solution {
    public int hIndex(int[] citations) {
        int r = Integer.MIN_VALUE;
        int l = 0;
        if(citations.length == 1 && citations[0] > 1) return 1;
        else if(citations.length ==1 && citations[0] == 0) return 0;
        for(int a:citations) {
            r = Integer.max(r, a);
        }
        int possibleAns = 0;
        while(l <= r) {
            int mid = (l+r)/2;
            
            if(valid(citations, mid)) {
                possibleAns = Integer.max(possibleAns, mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        return possibleAns;
    }
    
    private boolean valid(int[] nums, int mid) {
        int count = 0;
        for(int a:nums) {
            if(a >=mid)
                count++;
        }
        return count >= mid;
    }
}
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) {
            return -1;
        }
        
        
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(isValid(bloomDay, m, k ,mid)) {
                r = mid -1;
            }
            else  l = mid +1;
        }
        
        return l;
    }
    
    private boolean isValid(int[] bloomDay, int m, int k, int mid) {
         int count = 0;
        int flowers = 0;
        int len = bloomDay.length;
        for(int i=0;i<len;i++)
        {
            if(bloomDay[i] <= mid)
                flowers++;
            else    flowers = 0;
            
            if(flowers == k)
            {
                count++;
                flowers=0;
            }
        }
        if(count < m)
            return false;
        else    return true;
    }
    
}
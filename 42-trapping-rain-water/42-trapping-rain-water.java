class Solution {
    public int trap(int[] height) {
        int n = height.length, maxIndex = 0, max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++) {
            if(max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        
        int area = 0, maxSoFar = Integer.MIN_VALUE;
        for(int i = 0; i< maxIndex; i++) {
            if(maxSoFar < height[i]) {
                maxSoFar = height[i];
            }
            area += maxSoFar;
        }
        maxSoFar = Integer.MIN_VALUE;
        for(int i = n-1; i >= maxIndex; i--) {
            if(maxSoFar < height[i]) {
                maxSoFar = height[i];
            }
            area += maxSoFar;
        }
        
        for(int i = 0; i< n; i++) area -= height[i];
        
        return area;
    }
}
class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int i = 0, j = height.length-1;
        while(i<j) {
            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min*(j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }
        // for(int i=0; i<height.length; i++) {
        //     for(int j = i+1; j<height.length; j++) {
        //         int min = Math.min(height[i], height[j]);
        //         max = Math.max(max, min* (j-i));
        //     }
        // }
        
        return max;
    }
}
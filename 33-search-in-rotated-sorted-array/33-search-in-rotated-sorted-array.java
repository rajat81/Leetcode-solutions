class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
         //   System.out.println(mid);
            if(nums[mid] == target) return mid;
            boolean mid_big = nums[mid] >= nums[0];
            boolean target_big = target >= nums[0];
            
            if(mid_big == target_big) {
                if(target < nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(mid_big) {
                    start = mid +1;
                } else {
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
}
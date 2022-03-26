class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        while(j <= k) {
            if(nums[j] == 0) {
                //swap i and j and 
                int p = nums[i];
                nums[i] = nums[j];
                nums[j] = p;
                i++;
            } else if(nums[j] == 2) {
                //swap j and k
                int p = nums[k];
                nums[k] = nums[j];
                nums[j] = p;
                j--;
                k--;
            }
            
            j++;
        }
        
        return;
    }
}
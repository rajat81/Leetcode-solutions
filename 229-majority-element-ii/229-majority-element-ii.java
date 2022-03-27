class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int p:nums) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        double t = Math.floor(nums.length/3);
        List<Integer> ans = new ArrayList<>();
        
        for(int p: map.keySet()) {
            if(map.get(p) > t) ans.add(p);
        }
        
        return ans;
    }
}
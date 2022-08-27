class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int a:nums) 
            map.put(a, map.getOrDefault(a, 0) +1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> q = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for(Map.Entry entry: map.entrySet()) {
            q.add(entry);
        }
        
        int[] ans = new int[k];
        int p = 0;
        for(int i= 0; i<k;i++) {
            Map.Entry<Integer, Integer> entry = q.poll();
            ans[p++] = entry.getKey();
        }
        
        return ans;
    }
}
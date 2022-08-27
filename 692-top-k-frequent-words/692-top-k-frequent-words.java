class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) :b.getValue()-a.getValue());
        
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry s: map.entrySet()) {
            {
                pq.add(s);
            } 
        }
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i<k; i++) {
            list.add(pq.poll().getKey());
        }
        // Collections.sort(list);
        return list;
    }
    
  
}

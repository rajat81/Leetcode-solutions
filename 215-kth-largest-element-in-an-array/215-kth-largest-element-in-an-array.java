class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int a: nums) {
            if(pq.size() > k) {
                pq.add(a);
                pq.poll();
            } else if(pq.size() == k) {
                pq.add(a);
                pq.poll();
            } else {
                pq.add(a);
            }
        }
        
        return pq.peek();
    }
}
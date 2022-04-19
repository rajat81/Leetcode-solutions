class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        
        for(int[] a:edges) {
            for(int p:a) {
                if(set.contains(p)) return p;
                set.add(p);
            }
        }
        return -1;
    }
}
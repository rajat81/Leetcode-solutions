class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while(!stack.isEmpty()) {
            List<Integer> key = rooms.get(stack.pop());
            
            for(int key1: key) {
                if(!set.contains(key1)) {
                    set.add(key1);
                    stack.add(key1);
                }
            }
        }
        
        return rooms.size() == set.size();
    }
}
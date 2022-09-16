class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);
        for(int[] a:prerequisites) {
            List<Integer> l = map.getOrDefault(a[0], new ArrayList<>());
            l.add(a[1]);
            map.put(a[0], l);
        }
        
        for(int i = 0; i< numCourses; i++) {
      //      boolean[] visited = new boolean[numCourses];
            if(!dfs(i, map, visited))
                return false;
        }
            
        return true;

    }
    
    
    private boolean dfs(int node, Map<Integer, List<Integer>> map, int[] visited) {
        List<Integer> courses = map.getOrDefault(node, new ArrayList<>());
        
        // no prerequisites
        if(courses.isEmpty()) return true;
        // if alwready visited
        if(visited[node] == 2) return false;
        if(visited[node] == 1) return true;
        visited[node] = 2;
        for(int course: courses) {
            if(!dfs(course, map, visited)) {
                return false;
            }
        }
        visited[node] = 1;
        return true;
    }
}
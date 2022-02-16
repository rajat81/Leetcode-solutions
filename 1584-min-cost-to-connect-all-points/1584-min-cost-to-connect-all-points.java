class Solution {
    int[] parent;
    private int find(int i) {
        if(parent[i] == i) return i;
        return find(parent[i]);
    }
    
    private boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
    
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa < pb) {
            parent[pb] = pa;
        } else parent[pa] = pb;
    }
    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        for(int i = 0; i< points.length; i++) parent[i] = i;
        if(points.length == 0) return 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // create edges
        for(int i=0; i< points.length; i++) {
            for(int j = i+1; j < points.length; j++) {
                int[] s = points[i];
                int[] t = points[j];
                
                q.add(new int[] {Math.abs(s[1]-t[1])+Math.abs(s[0]-t[0]), i, j});
            }
        }
        
        int edgeCount = 0, ans = 0;
        while(!q.isEmpty() && edgeCount < points.length) {
            int[] edge = q.poll();
            if(!isConnected(edge[1], edge[2])) {
                union(edge[1], edge[2]);
                edgeCount++;
                ans += edge[0];
            }
        }
        
        return ans;
        
    }
}
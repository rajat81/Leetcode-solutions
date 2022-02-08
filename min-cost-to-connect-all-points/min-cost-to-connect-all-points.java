class Solution {
    int[] parent;
    private int find(int u) {
        if(parent[u] == u) return u;
        return find(parent[u]);
    }
    
    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if(pa!=pb) {
            if(pa > pb) parent[pa] = pb;
            else parent[pb] = pa;
        }
    }
    
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
    
    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        for(int i = 0; i< points.length; i++) parent[i] = i;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0; i< points.length; i++) {
            for(int j = i+1; j< points.length; j++) {
                int[] p = points[i];
                int[] r = points[j];
                q.add(new int[] {Math.abs(p[0] - r[0]) + Math.abs(p[1] - r[1]), i, j});
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
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
// ___________ recent approach
class Solution {
    public int minimumCost(int n, int[][] connections) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]); // pq with increasing cost
        if(connections.length < n-1) {
            return -1;
        }
        for(var connection: connections) {
            pq.add(connection);
        }

        int cost = 0;
        int edge = 0;
        ComponentFinder cf = new ComponentFinder(n);
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int[] current = new int[]{curr[0] - 1, curr[1]-1, curr[2]};

            if(!cf.isConnected(current[0], current[1])) {
                System.out.println("adding node:" + current[0] + " " + current[1]);
                cost += current[2];
                cf.addEdge(current);
                edge++;
            }
        }
        return edge == n-1 ? cost : -1;
    }
}

class ComponentFinder {
    int n;
    int[] parent;

    public ComponentFinder(int n) {
        this.n = n;
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int getParent(int node) {
        if(node == parent[node]) return node;
        return getParent(parent[node]);
    }

    public void addEdge(int[] edge) {
        int u = getParent(edge[0]);
        int v = getParent(edge[1]);

        if(u>v) {
            parent[u] = v;
        }
        else
            parent[v] = u;
    }


    public boolean isConnected(int a, int b) {
        return getParent(a) == getParent(b);
    }
}

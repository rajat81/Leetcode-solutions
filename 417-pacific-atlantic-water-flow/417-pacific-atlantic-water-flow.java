class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int H= heights.length;
        int W = heights[0].length;
        boolean[][] pacific = new boolean[H][W];
        boolean[][] atlantic = new boolean[H][W];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< H; i++) {
            dfs(pacific, heights, i, 0, Integer.MIN_VALUE);
            dfs(atlantic, heights, i, W-1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i< W; i++) {
            dfs(pacific, heights, 0, i, Integer.MIN_VALUE);
            dfs(atlantic, heights, H-1, i, Integer.MIN_VALUE);
        }
        for(int i = 0;i<H; i++) {
            for(int j = 0;j<W; j++) {
                if(atlantic[i][j] && pacific[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    
    private void dfs(boolean[][] ocean, int[][] heights, int i, int j, int prev) {
        if(i <0|| i>=heights.length || j<0 || j >= heights[0].length )
            return;
        if( ocean[i][j] || heights[i][j]<prev) return;
        ocean[i][j] = true;
        dfs(ocean, heights, i+1, j, heights[i][j]);
        dfs(ocean, heights, i-1, j, heights[i][j]);
        dfs(ocean, heights, i, j+1, heights[i][j]);
        dfs(ocean, heights, i, j-1, heights[i][j]);
    }
}
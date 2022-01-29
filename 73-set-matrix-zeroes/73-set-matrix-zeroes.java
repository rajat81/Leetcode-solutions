class Solution {
    public void setZeroes(int[][] mat) {
        int H = mat.length;
        int W = mat[0].length;
        
        boolean[] isZero = new boolean[W];
        
        for(int row = 0; row<H; ++row) {
            for(int col = 0; col<W; ++col) {
                if (mat[row][col] == 0) 
                    isZero[col] = true;
            }
        }
        
        
        for(int row = 0; row<H; row++) {
            boolean zero = false;
            for(int col = 0; col<W; col++) {
                if(mat[row][col] == 0) zero = true;    
            }
            
            for(int col = 0; col < W; col++) {
                if(zero || isZero[col]) mat[row][col] = 0;
            }
        }
    }
}
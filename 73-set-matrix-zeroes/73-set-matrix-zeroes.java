class Solution {
    public void setZeroes(int[][] mat) {
        int H = mat.length;
        int W = mat[0].length;
        
   //     boolean[] isZero = new boolean[W];
        boolean isFirstZero = false;
        
        for(int row = 0; row<H; ++row) {
            for(int col = 0; col<W; ++col) {
                if(row == 0 && mat[row][col] == 0) isFirstZero = true;
                if (mat[row][col] == 0) 
                    mat[0][col] = 0;    // whole col should be zero
            }
        }
        
        
        for(int row = 1; row<H; row++) {
            boolean zero = false;
            for(int col = 0; col<W; col++) {
                if(mat[row][col] == 0) zero = true;    
            }
            
            for(int col = 0; col < W; col++) {
                if(zero || mat[0][col] == 0) mat[row][col] = 0;
            }
        }
        if(isFirstZero) {
            for(int col = 0; col<W; col++) {
                mat[0][col] = 0;    
            }
        }
    }
}
class Solution {
    List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        solve(n, n, "");    
        return ans;
    }
    
    private void solve(int open, int close, String s) {
        if(open == 0 && close == 0) {
            ans.add(s);
            return;
        }
        if(open > 0) solve(open-1, close, s+"(");
        if(open == close) {
            return;
        }
        if(close>0) solve(open, close-1, s+")");
        return;
    }
}
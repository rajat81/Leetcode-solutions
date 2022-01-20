class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        
        solve(s, "", 0);
        return ans;
    }
    
    private void solve(String s, String op, int index) {
        
        if(index == s.length()) {
            ans.add(op);
            return;
        }
        if(Character.isLetter(s.charAt(index))) {
            solve(s, op + Character.toUpperCase(s.charAt(index)), index+1);
            solve(s, op + Character.toLowerCase(s.charAt(index)), index+1);
            return;
        }

        solve(s, op+s.charAt(index), index+1);
        return;
        
    }
}
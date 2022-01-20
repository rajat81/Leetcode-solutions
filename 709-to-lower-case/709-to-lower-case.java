class Solution {
    public String toLowerCase(String s) {
        String op = "";
                
        return solve(s, op, 0);
    }
    
    public String solve(String s, String op, int index) {
        if(op.length() == s.length()) {
            return op;
        }
        if(Character.isUpperCase(s.charAt(index))) {
            op += "" + Character.toLowerCase(s.charAt(index));
        } else op += "" + s.charAt(index);
        
        // System.out.println(op);
        return solve(s, op, index+1);
    }
}
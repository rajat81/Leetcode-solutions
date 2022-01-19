class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return s;
        int n = s.length(), ans;
        int start = 0, end = start;
        
        for(int i = 0; i< n; i++) {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i+1);
            
            ans = Math.max(l1, l2);
            if(ans > end - start) {
                start = i - (ans - 1)/2;
                end = i + (ans)/2;
            }
        }
        
        return s.substring(start, end+1);
        
    }
    
    private int expand(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // return the length of possible subString
        return r-l-1;
    }
}
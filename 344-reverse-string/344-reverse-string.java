class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i<n/2; i++) {
            char f = s[i];
            char s1 = s[s.length-1-i];
            
            s[s.length-1-i] = f;
            s[i] = s1;
        }
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        
        return longestPrefix(strs,0,strs.length-1);
    }
    
private String longestPrefix(String[] s,int l,int r){
    if(l==r) return s[l];
    else{
        int mid = (l+r)/2;
        String left = longestPrefix(s,l,mid);
        String right= longestPrefix(s,mid+1,r);
        return commonPrefix(left,right);
    }
}
    String commonPrefix(String l,String r){
        int min = Math.min(l.length(),r.length());
        for(int i = 0;i<min;i++){
        if(l.charAt(i)!=r.charAt(i))
            return l.substring(0,i);
        }
        return l.substring(0,min);
    }
}
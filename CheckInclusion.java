/*
* Given two strings s1 and s2, return true if s2 contains a
permutation
of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> ideal = getHashMap(s1);
        Map<Character, Integer> current = new HashMap<>();
        int len = s1.length();
        int start = 0;
        int end = start;

        while(end < s2.length()) {
            // process end
            current.put(s2.charAt(end), current.getOrDefault(s2.charAt(end), 0) + 1);
            
            //check for window
            if(end - start + 1 < len) {
                end++;
            } else if(end - start + 1 == len) {
                if (current.equals(ideal)) {
                    return true;
                }
                int count = current.get(s2.charAt(start));
                if(count == 1) {
                    current.remove(s2.charAt(start));
                } else {
                    current.put(s2.charAt(start), count-1);
                }
                start++;
                end++;
            }
        }

        return false;
    }

    private Map<Character, Integer> getHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}

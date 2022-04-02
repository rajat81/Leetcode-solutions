class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = preProcess();
        formString(digits, 0, "", map);
        if(ans.get(0) == "") return new ArrayList<>();
        return ans;
    }
    
    private void formString(String digit, int index, String current,
                           Map<Integer, List<Character>> map) {
        if(index == digit.length()) {
            ans.add(current);
            return;
        }
        
        for(Character c: map.get(Integer.parseInt(digit.charAt(index)+""))) {
            formString(digit, index+1, current+""+c, map);
        }
    }
    
    private Map<Integer, List<Character>> preProcess() {
        Map<Integer, List<Character>> map = new HashMap<>();
        char c = 'a';
        
        for(int k = 2; k<7; k++) {
        
            List<Character> list = new ArrayList<>();
            for(int i = 0; i< 3; i++) {
                list.add(c++);
            }
            map.put(k, list);

        }
        c = 'p';
        List<Character> list = new ArrayList<>();
        for(int i = 0; i< 4; i++) {
            list.add(c++);
        }
        map.put(7, list);
        
        List<Character> list1 = new ArrayList<>();
        c = 't';
            for(int i = 0; i< 3; i++) {
                list1.add(c++);
            }
            map.put(8, list1);
        List<Character> list2 = new ArrayList<>();
        c = 'w';
            for(int i = 0; i< 4; i++) {
                list2.add(c++);
            }
            map.put(9, list2);
        return map;
    }
}
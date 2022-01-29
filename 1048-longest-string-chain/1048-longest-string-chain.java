class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] score;
    
    private int longestLength(int i, int[] score) {
        if(score[i] != 0) return score[i];
        score[i] = 1;
        for(int b:edges.get(i)) {
            score[i] = Integer.max(score[i], longestLength(b, score)+1);
        }
        return score[i];
    }
    
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> pair = new HashMap<>();
        int n = words.length;
        for(int i = 0 ; i< n; i++) edges.add(new ArrayList<>());
        score = new int[n];
        for(int i=0; i<n; i++) pair.put(words[i], i);

        for(int i = 0; i< n; i++) {
            String s = words[i];
            for(int j = 0; j < s.length(); j++) {
                String maybe = s.substring(0, j) + s.substring(j+1);
                if(pair.keySet().contains(maybe)) {
                    edges.get(i).add(pair.get(maybe));
                }
            }
        }

        int ans = 0;
        for(int i=0; i< n; i++) ans = Integer.max(ans, longestLength(i, score));
        return ans;
    }
}
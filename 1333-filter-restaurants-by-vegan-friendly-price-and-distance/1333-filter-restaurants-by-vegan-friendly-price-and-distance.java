class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance)   {
        List<int[]> list  = Arrays.stream(restaurants).filter(a -> a[3] <= maxPrice)
                .filter(a -> a[4] <= maxDistance)
                .filter(a -> veganFriendly==1 ? a[2] == veganFriendly:true).collect(Collectors.toList());
        
        Collections.sort(list, (a, b) -> b[1] == a[1]? b[0]-a[0]: b[1] - a[1]);

        
        List<Integer> ans = new ArrayList<>();
        for(int[] p: list) {
            ans.add(p[0]);
        }
        return ans;
    }
}
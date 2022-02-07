// https://binarysearch.com/problems/Friend-Groups

import java.util.*;

class FriendGroups {
    public int solve(int[][] friends) {
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> q = new LinkedList<>();
        
        int count = 0;
     //   System.out.println("Hi! Value of count:" + count);

        while(firstUnvisited(visited) != -1) {
            q.offer(firstUnvisited(visited));
            while(!q.isEmpty()) {
                int a = q.poll();

                visited[a] = true;
                for(int friend:friends[a]) {
                    if(!visited[friend])
                        q.add(friend);
                }
            }
            count++;
         //   System.out.println("Hi! Value of count:" + count);
        }

        return count;
    }

    private int firstUnvisited(boolean[] visited) {
        for(int i = 0; i< visited.length; i++) {
            boolean p = visited[i];
            if(!p) {
                return i;
            }
        }

        return -1;
    } 
}

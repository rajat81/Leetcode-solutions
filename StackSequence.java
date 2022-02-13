/*
Given a list of distinct integers pushes, and another list of integers pops, return whether this is a valid sequence of stack push and pop actions.

Constraints

n ≤ 100,000 where n is the length of pushes
m ≤ 100,000 where m is the length of pops
Example 1:
Input
pushes = [0, 1, 4, 6, 8]
pops = [1, 0, 8, 6, 4]
Output
true
Explanation
We can first push [0, 1], then pop both off. Then push [4, 6, 8] and then pop them all off.

*/
import java.util.*;

class Solution {
    public boolean solve(int[] pushes, int[] pops) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < pushes.length && j < pops.length) {
            stack.push(pushes[i++]);

            while(!stack.isEmpty() && stack.peek() == pops[j]) {
                stack.pop();
                j++;
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}

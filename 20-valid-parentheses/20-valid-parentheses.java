class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(isOpening(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if(!stackTopMatches(stack, c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean stackTopMatches(Stack<Character> stack, char c) {
        return (c == ')' && stack.peek() == '(') 
            || (c == ']' && stack.peek() == '[') 
            || (c == '}' && stack.peek()=='{');
    }
}
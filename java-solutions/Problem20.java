/*
    20. Valid Parentheses
    
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
    
    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false
    
    Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */

public class Problem20 {
    public boolean isValid(String str) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put(')', '(');
        
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                s.push(c);
            } else {
                if (!s.isEmpty() && mapping.get(c) == s.peek()) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (!s.isEmpty()) {
            return false;
        }
        return true;
    }
}

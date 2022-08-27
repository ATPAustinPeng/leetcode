/*
    1249. Minimum Remove to Make Valid Parentheses

    Given a string s of '(' , ')' and lowercase English characters.
    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:
        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string.
    
    Example 1:
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"

    Example 3:
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.

    Constraints:
    1 <= s.length <= 105
    s[i] is either'(' , ')', or lowercase English letter.
*/

public class Problem1249 {
    public String minRemoveToMakeValid(String str) {
        // concept:
        // remove unncessary open parentheses then illegal closed parentheses
        // if there are remaining extra closed parentheses, you can start removing from the right to left

        // 2 pass solution
        // first pass, remove all invalid ')'
        // second pass, remove all invalid '(' (remove from right to left)
        
        StringBuilder sb = new StringBuilder();
        int extraOpen = 0;
        
        // remove all illegal closed parentheses
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // if char not '(' or ')'
            if (c != '(' && c != ')') {
                sb.append(c);
                continue;
            }
            
            // if char is '(', add to sb & increase counter
            if (c == '(') {
                sb.append(c);
                extraOpen++;
            }
            
            // if char is ')'
                // if counter > 0, add to sb & decrease counter
                // if counter <= 0, dont add
            if (c == ')') {
                if (extraOpen == 0) {
                    continue;
                }
                extraOpen--;
                sb.append(c);
            }
        }
        
        // remove any extra open parentheses right to left
        // StringBuilder sb2 = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            
            if (c == '(') {
                if (extraOpen > 0) {
                    extraOpen--;
                    sb.deleteCharAt(i);
                    continue;
                }
            }
        }
        
        return sb.toString();
    }

    // public String minRemoveToMakeValid(String s) {
    //     int counter = 0;
        
    //     StringBuilder sb = new StringBuilder();
        
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             counter++;
    //         } else if (c == ')') {
    //             counter--;
    //         }
            
    //         if (counter < 0) {
    //             counter++;
    //         } else {
    //             sb.append(c);
    //         }
    //     }
        
    //     for (int i = sb.length() - 1; i >= 0; i--) {
    //         char c = sb.charAt(i);
    //         if (c == '(' && counter > 0) {
    //             sb.deleteCharAt(i);
    //             counter--;
    //         }
    //     }
        
    //     return sb.toString();
    // }
}
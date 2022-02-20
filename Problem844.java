/*
    Problem 844. Backspace String Compare
    Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.

    Example 1:
    Input: s = "ab#c", t = "ad#c"
    Output: true
    Explanation: Both s and t become "ac".

    Example 2:
    Input: s = "ab##", t = "c#d#"
    Output: true
    Explanation: Both s and t become "".

    Example 3:
    Input: s = "a#c", t = "b"
    Output: false
    Explanation: s becomes "c" while t becomes "b".

    Constraints:
    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.

    Follow up: Can you solve it in O(n) time and O(1) space?
*/

public class Problem844 {
    public boolean backspaceCompare(String s, String t) {
        // Solution 1: for loop, remove 2 characters when # is encountered
            // and not at the beginning of string
        // super slow runtime
        s = removeHashtag(s);
        t = removeHashtag(t);
        return s.equals(t);
    }
    
    private String removeHashtag(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == '#') {
                if (i + 1 >= s.length()) {
                    s = s.substring(0, i - 1);
                } else {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                }
                i = i - 2;
            } else if (s.charAt(i) == '#') {
                s = s.substring(i);
            }
        }
        return s.replace("#", "");
    }
}
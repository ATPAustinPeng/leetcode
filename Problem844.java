/*
    844. Backspace String Compare
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
    // Solution 4:  pointer solution, don't build string, compare live
    public boolean backspaceCompare(String s, String t) {
        int sCounter = s.length() - 1;
        int tCounter = t.length() - 1;
        
        int sIgnore = 0;
        int tIgnore = 0;
        
        while (sCounter >= 0 || tCounter >= 0) {
            char sChar = sCounter >= 0 ? s.charAt(sCounter) : '-';
            if (sChar == '#') {
                sIgnore++;
                sCounter--;
            } else if (sIgnore > 0) {
                sIgnore--;
                sCounter--;
            } else {
                char tChar = tCounter >= 0 ? t.charAt(tCounter) : '-';
                tCounter--;
                if (tChar == '#') {
                    tIgnore++;
                } else if (tIgnore > 0) {
                    tIgnore--;
                    // tCounter--;
                } else if (sChar != tChar) {
                    return false;
                } else {
                    sCounter--;
                }
            }
        }
        
        return true;
    }

    // Solution 3: pointer solution, work backwards and track number of '#'
    // when comparing, use an "ignoreCount" to know how many words to skip if not '#'
    // public boolean backspaceCompare(String s, String t) {
    //     return buildString(s).equals(buildString(t));
    // }

    // private String buildString(String x) {
    //     StringBuilder sb = new StringBuilder();
        
    //     int ignoreCount = 0;
        
    //     for (int i = x.length() - 1; i >= 0; i--) {
    //         if (x.charAt(i) == '#') {
    //             ignoreCount++;
    //         } else {
    //             if (ignoreCount > 0) {
    //                 ignoreCount--;
    //             } else if (i - ignoreCount >= 0) {
    //                 sb.append(x.charAt(i - ignoreCount));
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }

    // Solution 2: use stacks to create final string
    // public boolean backspaceCompare(String s, String t) {
    //     Stack<Character> sStack = new Stack<Character>();
    //     Stack<Character> tStack = new Stack<Character>();
        
    //     for (char c : s.toCharArray()) {
    //         if (c == '#') {
    //             if (sStack.size() > 0) {
    //                 sStack.pop();
    //             }
    //         } else {
    //             sStack.push(c);
    //         }
    //     }
        
    //     for (char c : t.toCharArray()) {
    //         if (c == '#') {
    //             if (tStack.size() > 0) {
    //                 tStack.pop();
    //             }
    //         } else {
    //             tStack.push(c);
    //         }
    //     }
        
    //     if (sStack.size() != tStack.size()) {
    //         return false;
    //     }
        
    //     while (sStack.size() > 0 & tStack.size() > 0) {
    //         if (sStack.pop() != tStack.pop()) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // Solution 1: for loop, remove 2 characters when # is encountered and not at the beginning of string
    // public boolean backspaceCompare(String s, String t) {
    //     s = removeHashtag(s);
    //     t = removeHashtag(t);
    //     return s.equals(t);
    // }

    // private String removeHashtag(String s) {
    //     for (int i = 0; i < s.length(); i++) {
    //         if (i != 0 && s.charAt(i) == '#') {
    //             if (i + 1 >= s.length()) {
    //                 s = s.substring(0, i - 1);
    //             } else {
    //                 s = s.substring(0, i - 1) + s.substring(i + 1);
    //             }
    //             i = i - 2;
    //         } else if (s.charAt(i) == '#') {
    //             s = s.substring(i);
    //         }
    //     }
    //     return s.replace("#", "");
    // }
}
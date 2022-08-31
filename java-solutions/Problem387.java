/*
    387. First Unique Character in a String

    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    Example 1:
    Input: s = "leetcode"
    Output: 0

    Example 2:
    Input: s = "loveleetcode"
    Output: 2

    Example 3:
    Input: s = "aabb"
    Output: -1
    
    Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.
 */

public class Problem387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> timesSeen = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (!timesSeen.containsKey(c)) {
                timesSeen.put(c, 1);
            } else {
                timesSeen.put(c, timesSeen.get(c) + 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (timesSeen.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}

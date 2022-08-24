/*
    205. Isomorphic Strings

    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.

    Example 1:
    Input: s = "egg", t = "add"
    Output: true

    Example 2:
    Input: s = "foo", t = "bar"
    Output: false
    
    Example 3:
    Input: s = "paper", t = "title"
    Output: true
    
    Constraints:
    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
*/

public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        // using hashmap results in storing 2x the amt of data
//         Map<String, String> st = new HashMap<>();
//         Map<String, String> ts = new HashMap<>();
        
//         for (int i = 0; i < s.length(); i++) {
//             String sChar = "" + s.charAt(i);
//             String tChar = "" + t.charAt(i);
            
//             if (st.containsKey(sChar) && !st.get(sChar).equals(tChar)) {
//                 return false;
//             } else if (ts.containsKey(tChar) && !ts.get(tChar).equals(sChar)) {
//                 return false;
//             }
//             st.put(sChar, tChar);
//             ts.put(tChar, sChar);
//         }
        
        int[] st = new int[256];
        int[] ts = new int[256];
        
        // we know exactly where to add and where to lookup (use array)
        for (int i = 0; i < st.length; i++) {
            st[i] = -1;
            ts[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (st[sChar] != -1 && tChar != st[sChar]) {
                return false;
            } else if (ts[tChar] != -1 && sChar != ts[tChar]) {
                return false;
            }
            
            st[sChar] = tChar;
            ts[tChar] = sChar;
        }
        
        return true;
    }
}
/*
    409. Longest Palindrome

    Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

    Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

    Example 2:
    Input: s = "a"
    Output: 1
    Explanation: The longest palindrome that can be built is "a", whose length is 1.

    Constraints:
    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.
*/

public class Problem409 {
    public int longestPalindrome(String s) {
        // FASTER: using static data structure (no dynamic increase in size)
        // possible because String s is constructed using English letters only
        char[] letterOccurrences = new char[128];
        
        for (int i = 0; i < s.length(); i++) {
            letterOccurrences[s.charAt(i)]++;
        }
        
        int length = 0;
        boolean oddUsedOnce = false;
        for (int i = 0; i < letterOccurrences.length; i++) {
            if (letterOccurrences[i] % 2 == 0) {
                length += letterOccurrences[i];
            } else if (!oddUsedOnce) {
                length += letterOccurrences[i];
                oddUsedOnce = true;
            } else {
                length += (letterOccurrences[i] - 1);
            }
        }
        
        return length;
            
        // SLOW: using Map
        // map stores (character, # of occurrences)
        // if there are 2 copies -> +2
        // if there is any 1 copy -> +1 (can only happen once per string)
//         Map<Character, Integer> hmap = new HashMap<>();
        
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (!hmap.containsKey(c)) {
//                 hmap.put(c, 1);
//             } else {
//                 hmap.put(c, hmap.get(c) + 1);
//             }
//         }
        
//         int length = 0;
//         boolean usedOneOddEntry = false;
        
//         for (Map.Entry<Character, Integer> charOccurence: hmap.entrySet()) {
//             // 3 cases:
//                 // even -> add to length
//                 // first odd occurrence -> add to length
//                 // second and beyond odd -> -1 then add to length
//             if (charOccurence.getValue() % 2 == 0) {
//                 length += charOccurence.getValue();
//             } else if (!usedOneOddEntry) {
//                 length += charOccurence.getValue();
//                 usedOneOddEntry = true;
//             } else {
//                 length += charOccurence.getValue() - 1;
//             }
//         }
        
//         return length;
    }
}
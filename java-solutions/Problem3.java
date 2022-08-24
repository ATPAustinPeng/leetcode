/*
    3. Longest Substring Without Repeating Characters

    Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    
    Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
//         // optimization, keep index of repeated character to contract window immediately
        
//         //Map<Character, Integer> window = new HashMap<>();
//         Integer[] window = new Integer[128];
//         int maxLen = 0;
        
//         int left = 0;
//         int right = 0;
        
//         // while right < string length, keep expanding the window
//         while (right < s.length()) {
//             char r = s.charAt(right);
            
//             Integer index = window[r];
            
//             // if expanding the sliding window, there is a dupe, contract the window
//             if (window[r] != null && index >= left && index < right) {
//                 left = index + 1;
//             }
            
//             // update length
//                 // take max of original length & new length
//             maxLen = Math.max(maxLen, right - left + 1);
            
//             // update charset with new location of rightPtr's character
//             window[r] = right;
            
//             right++;
//         }
//         return maxLen;
        
        // array set to track dupes (set doesn't work because it can only check 1 copy)
        // use sliding window (left and right pointers)
        // expand window (move right pointer) when no dupes in the window
        // contract window (move left pointer) when there are dupes in the window
        
        int[] charset = new int[128];
        int maxLen = 0;
        
        int left = 0;
        int right = 0;
        
        // while right < string length, keep expanding the window
        while (right < s.length()) {
            char r = s.charAt(right);
            charset[r]++;
            
            // if expanding the sliding window, there is a dupe, contract the window
            while (charset[r] > 1) {
                char l = s.charAt(left);
                charset[l]--;
                left++;
            }
            
            // update length
                // take max of original length & new length
            maxLen = Math.max(maxLen, right - left + 1);
            
            right++;
        }
        return maxLen;
    }
}
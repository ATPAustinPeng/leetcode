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
        int[] charCounts = new int[26 + 26 + 6];
        
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'A']++;
        }
        
        int longestPalindromeLen = 0;
        boolean usedSingle = false;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] % 2 == 0) {
                longestPalindromeLen += charCounts[i];
            } else if (!usedSingle) {
                usedSingle = true;
                longestPalindromeLen += charCounts[i];
            } else {
                longestPalindromeLen += charCounts[i] - 1;
            }
        }
        
        return longestPalindromeLen;
    }
}
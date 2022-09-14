/*
    1328. Break a Palindrome

    Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
    Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
    A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

    Example 1:
    Input: palindrome = "abccba"
    Output: "aaccba"
    Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
    Of all the ways, "aaccba" is the lexicographically smallest.
    
    Example 2:
    Input: palindrome = "a"
    Output: ""
    Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
    
    Constraints:
    1 <= palindrome.length <= 1000
    palindrome consists of only lowercase English letters.
 */

public class Problem1328 {
    public String breakPalindrome(String p) {
        // using char array and changing is faster than substring
        int len = p.length();
        
        if (len <= 1) {
            return "";
        }
        
        char[] letters = p.toCharArray();
        
        // if this loop passes that means p is made up of 'a' only
        for (int i = 0; i < len / 2; i++) {
            if (letters[i] != 'a') {
                letters[i] = 'a';
                return String.valueOf(letters);
            }
        }
        
        letters[len - 1] = 'b';
        return String.valueOf(letters);
    }
    
//     public String breakPalindrome(String p) {
//         // length <= 1 will always be a palindromre
//         if (p.length() <= 1) {
//             return "";
//         }
        
//         // to make smallest lexicographic, change letter from left to right
//         // set the letter to a if not already a, and to b if it is already a
//         boolean hasUpdatedStr = false;
//         for (int i = 0; i < p.length() / 2; i++) {
//             if (p.charAt(i) != 'a') {
//                 hasUpdatedStr = true;
//                 return p.substring(0, i) + "a" + p.substring(i + 1);
//             }
//         }
        
//         if (hasUpdatedStr == false) {
//             for (int i = p.length() - 1; i > p.length() / 2 - 1; i--) {
//                 if (p.charAt(i) != 'b') {
//                     hasUpdatedStr = true;
//                     return p.substring(0, i) + "b" + p.substring(i + 1);
//                 }
//             }
//         }
        
//         return "";
//     }
}
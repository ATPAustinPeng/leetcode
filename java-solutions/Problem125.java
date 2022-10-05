/*
    125. Valid Palindrome

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
    it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.

 

    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
    
    Constraints:
    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.
*/

public class Problem125 {
    public boolean isPalindrome(String s) {
        // ASCII value of uppercase alphabets – 65 to 90. ASCII value of lowercase alphabets – 97 to 122.
        int l = 0;
        int r = s.length() - 1;
        
        s = s.toLowerCase();
        
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
        
        
        // TOO SLOW! remove all non alphabetic and convert all upper to lower case
//         s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

//         int n = s.length();
        
//         for (int i = 0; i < n / 2; i++) {
//             if (s.charAt(i) != s.charAt(n - i - 1)) {
//                 return false;
//             }
//         }
//         return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return (c - 'A' >= 0 && c - 'A' < 26) || (c - 'a' >= 0 && c - 'a' < 26) || (c - '0' >= 0 && c - '0' < 10);
    }
}
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
        // 2 pointers: left and right
        // check left and right not space or special, left and right don't intersect
        // case 1: left == right (alphabet only) -> contract left and right
        // case 2: left != right -> break
        
        s = s.toLowerCase();
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            
            // check is alphabet
            while (!isAlphanumeric(s.charAt(left)) && left < right) {
                left++;
            }
            
            while (!isAlphanumeric(s.charAt(right)) && left < right) {
                right--;
            }
            
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return (c - 'A' >= 0 && c - 'A' < 26) || (c - 'a' >= 0 && c - 'a' < 26) || (c - '0' >= 0 && c - '0' < 10);
    }
}
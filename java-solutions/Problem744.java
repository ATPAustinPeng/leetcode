/*
    744. Find Smallest Letter Greater Than Target

    Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
    Note that the letters wrap around.
    For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

    Example 1:
    Input: letters = ["c","f","j"], target = "a"
    Output: "c"

    Example 2:
    Input: letters = ["c","f","j"], target = "c"
    Output: "f"

    Example 3:
    Input: letters = ["c","f","j"], target = "d"
    Output: "f"

    Constraints:
    2 <= letters.length <= 104
    letters[i] is a lowercase English letter.
    letters is sorted in non-decreasing order.
    letters contains at least two different characters.
    target is a lowercase English letter.
 */

public class Problem744 {
    public char nextGreatestLetter(char[] letters, char target) {
        // binary search is faster
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return letters[left % letters.length];
        
        // loop is slow
        // for (int i = 0; i < letters.length; i++) {
        //     if (letters[i] > target) {
        //         return letters[i];
        //     }
        // }
        // return letters[0];
    }
}

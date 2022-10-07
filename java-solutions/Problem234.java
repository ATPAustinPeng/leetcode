/*
    234. Palindrome Linked List

    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    
    Example 1:
    Input: head = [1,2,2,1]
    Output: true

    Example 2:
    Input: head = [1,2]
    Output: false

    Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

    Follow up: Could you do it in O(n) time and O(1) space?
 */

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode next = null;
        
        while (mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        
        ListNode last = prev;
        
        while (last != null) {
            if (last.val != head.val) {
                return false;
            }
            last = last.next;
            head = head.next;
        }
        
        return true;
    }
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}

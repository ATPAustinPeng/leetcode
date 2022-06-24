/*
    143. Reorder List

    You are given the head of a singly linked-list. The list can be represented as:
        L0 → L1 → … → Ln - 1 → Ln
    Reorder the list to be on the following form:
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    Example 1:
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

    Example 2:
    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]

    Constraints:
    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000
*/

public class Problem143 {
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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        
        // find middle point
        ListNode middle = head;
        ListNode end = head;
        
        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        }
        
        // reverse the second half of the linked list
        ListNode curr = middle;
        ListNode tempPrev = null;
        ListNode tempNext = curr;
        
        while (tempNext != null) {
            tempNext = curr.next;
            
            curr.next = tempPrev;
            tempPrev = curr;
            curr = tempNext;
        }
        
        // Note: after reversing, head includes the middle element!
        // ex. [L0, L1, L2, L3] -> [L0, L1, L2]
        // ex. [L0, L1, L2, L3, L4] -> [L0, L1, L2]
        
        // merge the linked list (until the right.next != null since left = head already contains the middle element AKA last element of right)
        // leftNext = left.next, point left.next to right, left = leftNext
        // rightNext = right.next, point right.next to left, right = rightNext
        ListNode right = tempPrev;
        ListNode left = head;
        
        tempNext = null;
        
        while (right.next != null) {
            tempNext = left.next;
            left.next = right;
            left = tempNext;
            
            tempNext = right.next;
            right.next = left;
            right = tempNext;
        }
    }
}
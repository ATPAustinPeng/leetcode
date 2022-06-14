/*
    2. Add Two Numbers

    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
    
    Constraints:
    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummyNode = result;
        boolean isFirst = true;
        boolean hasCarry = false;
        
        while (l1 != null && l2 != null) {
            int nodeSum = l1.val + l2.val;
            
            if (hasCarry) {
                nodeSum += 1;
            }
            
            hasCarry = false;
            if (nodeSum > 9) {
                hasCarry = true;
                nodeSum %= 10;
            }
            
            if (isFirst) {
                result.val = nodeSum;
            } else {
                ListNode newNode = new ListNode(nodeSum);
                dummyNode.next = newNode;
                dummyNode = dummyNode.next;
            }
            

            l1 = l1.next;
            l2 = l2.next;
            isFirst = false;
        }
        
        while (l1 != null) {
            if (hasCarry) {
                l1.val += 1;
            }
            
            hasCarry = false;
            if (l1.val > 9) {
                hasCarry = true;
                l1.val %= 10;
            }
            dummyNode.next = new ListNode(l1.val);
            dummyNode = dummyNode.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            if (hasCarry) {
                l2.val += 1;
            }
            
            hasCarry = false;
            if (l2.val > 9) {
                hasCarry = true;
                l2.val %= 10;
            }
            
            dummyNode.next = new ListNode(l2.val);
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }
        
        if (hasCarry) {
            dummyNode.next = new ListNode(1);
        }
        
        return result;
    }
}
/*
    445. Add Two Numbers II

    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
    Input: l1 = [7,2,4,3], l2 = [5,6,4]
    Output: [7,8,0,7]

    Example 2:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [8,0,7]

    Example 3:
    Input: l1 = [0], l2 = [0]
    Output: [0]
    
    Constraints:
    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
    
    Follow up: Could you solve it without reversing the input lists?
*/

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // solving by reversing input is easy, just reverse and add like normal "add two numbers" problem

        // without reversing input is so stupid, you're going to have to reverse anyways
        // three pass solution
            // determine length of each number
            // add numbers and don't carry (aka 1 + 9 = 10)
            // reverse output & perform carrying
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        int len1 = 0;
        int len2 = 0;
        
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }
        
        ListNode result = null;
        curr1 = l1;
        curr2 = l2;
        
        while (len1 > 0 && len2 > 0) {
            int placeSum = 0;
            if (len1 > len2) {
                placeSum += curr1.val;
                curr1 = curr1.next;
                len1--;
            } else if (len2 > len1) {
                placeSum += curr2.val;
                curr2 = curr2.next;
                len2--;
            } else {
                placeSum = curr1.val + curr2.val;
                curr1 = curr1.next;
                curr2 = curr2.next;
                len1--;
                len2--;
            }
            
            // reverse output to allow carrying
            ListNode temp = new ListNode(placeSum);
            temp.next = result;
            result = temp;
        }
        
        // 0 = false, 1 = true (that way I can add carry)
        int carry = 0;
        
        curr1 = result;
        result = null;
        while (curr1 != null) {
            // calculate value with carry
            int tempVal = curr1.val + carry;
            
            // reverse output to place back in order
            ListNode temp = new ListNode(tempVal % 10);
            temp.next = result;
            result = temp;
            
            // reset carry after using it
            carry = 0;
            
            // check if we need to carry
            if (tempVal >= 10) {
                carry = tempVal / 10;
            }
            curr1 = curr1.next;
        }
        
        if (carry != 0) {
            return new ListNode(carry, result);
        }
        
        return result;
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
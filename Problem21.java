public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // two pointer solution
        // if l1 <= l2, add l1 pointer
        // if l1 > l2, add l2 pointer
        ListNode result = new ListNode(Integer.MIN_VALUE);
        
        ListNode prev = result;
        while (list1 != null && list2 != null) {
            if (list2.val >= list1.val) {
                prev.next = list1;
                list1 = list1.next;
                prev = prev.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
                prev = prev.next;
            }
        }
        
        // rewrite to connect the 2 linked lists instead of iterating
//         while (list1 != null) {
//             prev.next = list1;
//             list1 = list1.next;
//             prev = prev.next;
//         }
        
//         while (list2 != null) {
//             prev.next = list2;
//             list2 = list2.next;
//             prev = prev.next;
//         }
        
//         if (list1 != null) {
//             prev.next = list1;
//         }
        
//         if (list2 != null) {
//             prev.next = list2;
//         }
        
        prev.next = list1 == null ? list2 : list1;
        
        return result.next;
    }
}
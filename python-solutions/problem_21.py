# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    new_head = ListNode(0, None)
    curr = new_head
    
    while list1 != None and list2 != None:
        if list1.val <= list2.val:
            curr.next = ListNode(list1.val)
            list1 = list1.next
        else:
            curr.next = ListNode(list2.val)
            list2 = list2.next
        curr = curr.next
        
    curr.next = list1 if list1 != None else list2
    return new_head.next
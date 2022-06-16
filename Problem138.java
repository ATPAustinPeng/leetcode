/*
    138. Copy List with Random Pointer
*/

public class Problem138 {
    public Node copyRandomList(Node head) {
        // create HashMap<Node, Node> original maps to an exact copy
        // iterate through the original linked list
            // use HashMap to get the copy
            // point copy to original.next's hashmap value
            // pointer copy.random to original.random's hashmap value
        
        Map<Node, Node> hm = new HashMap<>();
        
        Node dummy = head;
        while (dummy != null) {
            hm.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        
        Node headCopy = hm.get(head);
        
        while (head != null) {
            hm.get(head).next = hm.get(head.next);
            hm.get(head).random = hm.get(head.random);
            
            head = head.next;
        }
        
        return headCopy;
    }
}
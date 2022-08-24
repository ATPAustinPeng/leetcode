/*
    146. LRU Cache
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.

    Example 1:
    Input
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

    Output
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    Explanation
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
    

    Constraints:
    1 <= capacity <= 3000
    0 <= key <= 104
    0 <= value <= 105
    At most 2 * 105 calls will be made to get and put.
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Problem146 {
    // implement doubly linked list so you can add/remove nodes at any point in the linked list given the node
    // use a hashmap (int key, DLLNode node) so that you can get the node for easy add/remove

    class LRUCache {
        public int size;
        public int capacity;
        public Map<Integer, DLLNode> hmap;
        public DLLNode head;
        public DLLNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            hmap = new HashMap<>();
            head = new DLLNode();
            tail = new DLLNode();
            
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
            DLLNode temp = hmap.get(key);
            
            if (temp == null) {
                return -1;
            }
            
            justUsed(temp);
            return temp.value;
        }
        
        public void put(int key, int value) {
            DLLNode temp = hmap.get(key);
            
            if (hmap.get(key) != null) {
                // already exists (replace)
                remove(temp);
                
                temp.value = value;
                hmap.put(key, temp);
                
                add(temp);
            } else {
                // doesn't exist yet (add/evict)
                temp = new DLLNode();
                temp.key = key;
                temp.value = value;
                
                if (size < capacity) {
                    // not at capacity (add)
                    hmap.put(key, temp);
                    add(temp);
                    size++;
                } else if (size >= capacity) {
                    // at capacity (evict)
                    int removedKey = remove(tail.prev);
                    hmap.remove(removedKey);
                    hmap.put(key, temp);
                    add(temp);
                }
            }
        }
        
        class DLLNode {
            public int key;
            public int value;
            public DLLNode prev;
            public DLLNode next;
        }
        
        // head is MRU (add is always MRU)
        public void add(DLLNode node) {
            node.prev = head;
            node.next = head.next;
            
            head.next = node;
            node.next.prev = node;
        }
        
        // tail is LRU (always evict LRU)
        public int remove(DLLNode node) {
            DLLNode prev = node.prev;
            DLLNode next = node.next;
            
            prev.next = next;
            next.prev = prev;
            return node.key;
        }
        
        // move to right after head
        public void justUsed(DLLNode node) {
            remove(node);
            add(node);
        }
    }
}
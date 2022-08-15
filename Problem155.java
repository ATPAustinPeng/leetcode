/*
    155. Min Stack

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    Implement the MinStack class:
        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        You must implement a solution with O(1) time complexity for each function.

    Example 1:
    Input
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]
    Output
        [null,null,null,null,-3,null,0,-2]
    Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    
    Constraints:
    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

public class Problem155 {
    // 2 element int[] -> [value, currMin]
    Stack<int[]> stack = new Stack<>();;

    public MinStack() {}
    
    public void push(int val) {
        // handle empty stack -> if empty, val must be the minimum (also can't peek() empty stack)
        // handle non-empty stack -> if not empty, val or stack.peek()[1] must be min
        
        int[] entry = new int[2];
        entry[0] = val;
        entry[1] = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);
        stack.push(entry);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }

    /**
    * Your MinStack object will be instantiated and called as such:
    * MinStack obj = new MinStack();
    * obj.push(val);
    * obj.pop();
    * int param_3 = obj.top();
    * int param_4 = obj.getMin();
    */
}
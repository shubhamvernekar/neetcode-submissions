class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int ip[] = new int[]{val, val};
        if(!stack.isEmpty()) {
            ip[1] = Math.min(val, stack.peek()[1]);
        }
        stack.push(ip);
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
}

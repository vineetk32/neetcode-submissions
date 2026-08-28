class MinStack {

    private Deque<int[]> stack; // -1[max], 3[-1], -4[-1], 
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new LinkedList<>();
    }
    
    public void push(int val) {
        this.stack.offerLast(new int[]{val, this.min});
        this.min = Math.min(val, this.min);
    }
    
    public void pop() {
        int[] topElement = this.stack.pollLast();
        this.min = topElement[1];
    }
    
    public int top() {
        return this.stack.peekLast()[0];
    }
    
    public int getMin() {
        return this.min;
    }
}

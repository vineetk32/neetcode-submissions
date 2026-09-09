class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length]; // [1, , ,2,1,]
        // Base case - empty, null etc
        Deque<Integer> tempStack = new ArrayDeque<>(); // [1, 2, 3,  ] 
        for (int i = 0; i < temperatures.length; i++) { // 5
            int currTemp = temperatures[i]; //40
            // if current temp > top of stack, pop and update result
            while (!tempStack.isEmpty() && currTemp > temperatures[tempStack.peekLast()]) {
                int prevDay = tempStack.pollLast();
                results[prevDay] = (i - prevDay);
            }
            tempStack.addLast(i);
        }

        while (!tempStack.isEmpty()) {
            int prevDay = tempStack.pollLast();
            results[prevDay] = 0;
        }

        return results;
    }
}

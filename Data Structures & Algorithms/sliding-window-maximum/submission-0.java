class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Input: nums = [1,2,1,0,4,2,6], k = 3
        Map<Integer, Integer> window = new HashMap<>(); // 1: 1, 0: 1, 4: 1
        // 4, 2, 1, 1, 0
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //Base case: nums < k
        for (int i = 0; i < k; i++) {
            window.merge(nums[i], 1, Integer::sum);
            maxHeap.offer(nums[i]);
        }

        List<Integer> maxElements = new LinkedList<>(); // [2, 2]
        maxElements.add(maxHeap.peek());

        for (int i = k; i < nums.length; i++) {
            window.merge(nums[i], 1, Integer::sum);
            maxHeap.offer(nums[i]);
            updateWindow(window, nums[i - k]);

            while (!window.containsKey(maxHeap.peek())) {
                maxHeap.poll();
            }
            maxElements.add(maxHeap.peek());
        }

        return maxElements.stream()
        .mapToInt(Integer::intValue).toArray();
    }

    private void updateWindow(final Map<Integer, Integer> window, int element) {
        if (window.get(element) == 1) window.remove(element);
        else window.put(element, window.get(element) - 1);
    }

}

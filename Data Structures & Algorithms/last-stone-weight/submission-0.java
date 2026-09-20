class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones)
        .boxed()
        .forEach(a -> heap.add(a));

        while (heap.size() >= 2) {
            int heavierStone = heap.poll();
            int lighterStone = heap.poll();

            if (heavierStone > lighterStone) {
                heap.offer(heavierStone - lighterStone);
            }
        }

        if (heap.size() == 0) return 0;
        else return heap.poll();
    }
}

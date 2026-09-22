class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    } // [1, 2, 3, 4, 5, 6, 7, 8, 9]

    public void addNum(int num) {
        if (this.maxHeap.isEmpty() || num <= this.maxHeap.peek()) {
            this.maxHeap.offer(num);
        } else {
            this.minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (this.minHeap.size() == this.maxHeap.size()) {
            return (this.minHeap.peek() + this.maxHeap.peek()) / 2.0;
        } else if (this.minHeap.size() > this.maxHeap.size()) {
            return this.minHeap.peek();
        } else {
            return this.maxHeap.peek();
        }
    }
}

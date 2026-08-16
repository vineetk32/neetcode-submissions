class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> freqHeap = new PriorityQueue<int[]>((a,b) ->  Integer.compare(b[1], a[1]));
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num: nums) {
            int count = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            freqHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = freqHeap.poll()[0];
        }
        
        return topK;
    }
}

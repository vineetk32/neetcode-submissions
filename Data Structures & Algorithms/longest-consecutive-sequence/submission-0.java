class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toSet());

        int maxLength = 0;
        for (int num: nums) {
            if (!store.contains(num - 1)) {
                int length = 1;
                while (store.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
            return maxLength;
    }
}

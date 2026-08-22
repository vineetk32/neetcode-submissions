class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        int curr;
        while (start < end) {
            curr = numbers[start] + numbers[end];
            if (curr < target) {
                start++;
            } else if (curr > target) {
                end--;
            } else if (curr == target) {
                break;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}

class Solution {
    public int findMin(int[] nums) {
        // Base case
        // [4,5,0,1,2,3]
        int start = 0; //
        int end = nums.length - 1; //1
        int mid = 0;
        while (start < end) {
            System.out.printf("\nSearching between %d and %d", start, end);
            mid = start + (end - start) / 2; //2
            int midNum = nums[mid];//0
            if (midNum > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}

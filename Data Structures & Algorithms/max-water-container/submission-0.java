class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int start = 0, end = heights.length - 1;
        while (start < end) {
            int height = Math.min(heights[start], heights[end]);
            maxArea = Math.max((end - start) * height, maxArea);

            if (heights[start] > height) {
                end--;
            } else {
                start++;
            }
        }
        //Update pointer until a greater height is reached

        return maxArea;
    }
}

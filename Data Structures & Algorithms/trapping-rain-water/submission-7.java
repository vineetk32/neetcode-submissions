class Solution {
    public int trap(int[] heights) {
        int[] leftMax = new int[heights.length]; // 0, 2, 2, 3, 3, 3, 3, 3, 3, 3
        int[] rightMax = new int[heights.length]; //3, 3, 3, 3 ,3, 3, 3 ,3, 2, 1

        int maxSoFar = 0;
        for (int i = 0; i < heights.length; i++) {
            maxSoFar = Math.max(maxSoFar, heights[i]);
            leftMax[i] = maxSoFar;
        }

        maxSoFar = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, heights[i]);
            rightMax[i] = maxSoFar;
        }

        //System.out.println(Arrays.toString(leftMax));
        //System.out.println(Arrays.toString(rightMax));

        int totalWater = 0;
        for (int i = 0; i < heights.length; i++) {
            totalWater += (Math.min(leftMax[i], rightMax[i]) - heights[i]);
        }

        return totalWater;
    }
}

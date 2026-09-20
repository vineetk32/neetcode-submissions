class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> closestPoints = new PriorityQueue<>((x, y) -> Double.compare(getDistanceFromOrigin(x), getDistanceFromOrigin(y)));
        //TODO: base case - 0, null, < k
        for (int i = 0; i < points.length; i++) {
            closestPoints.add(points[i]);
        }

        int[][] kClosest = new int[k][2];

        for (int i = 0; i < k; i++) {
            kClosest[i] = closestPoints.poll();
        }

        return kClosest;
    }

    private double getDistanceFromOrigin(final int[] x) {
        return Math.hypot((double) x[0], (double)x[1]);
    }
}

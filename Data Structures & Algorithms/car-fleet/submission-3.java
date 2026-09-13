class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Base cases: null, 0
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        double[] minTimes = calculateTimeToTarget(cars, target);
        //System.out.println("MinTimes - " + Arrays.toString(minTimes));
        Deque<Double> fleets = new ArrayDeque<>();
        fleets.offerLast(minTimes[0]);
        for (int i = 1; i< minTimes.length; i++) {
            double currTime = minTimes[i];
            if (currTime > fleets.peekLast()) {
                fleets.offerLast(currTime);
            }
        }

        return fleets.size();
    }

    private double[] calculateTimeToTarget(final int[][] cars, final int target) {
        double[] minTimes = new double[cars.length];
        for (int i = 0; i < minTimes.length; i++) {
            double totalTime = (target - cars[i][0]) / (double) cars[i][1];
            minTimes[i] = totalTime;
        }

        return minTimes;
    }
}

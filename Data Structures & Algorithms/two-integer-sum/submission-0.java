class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Add all the nums into a hashmap
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexMap.get(target - nums[i]);

            if (index != null && index != i) return new int[]{i, index};
        }

        return new int[]{-1, -1};
    }
}

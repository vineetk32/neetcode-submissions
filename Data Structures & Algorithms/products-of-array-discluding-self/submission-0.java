class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Boundary conditions - empty array, null etc

        // Calculate the prefix Array
        int[] prefix = new int[nums.length];
        for (int i = 0; i < prefix.length; i++) {
            if (i == 0) prefix[i] = 1;
            else {
                prefix[i] = prefix[i - 1] * nums[i-1];
            }
        }

        int[] suffix = new int[nums.length];
        for (int i = suffix.length - 1; i >= 0; i--) {
            if (i == suffix.length - 1) suffix[i] = 1;
            else {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = prefix[i] * suffix[i];
        }

        return output;
    }
}  

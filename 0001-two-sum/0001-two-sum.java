class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] numsIndex = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            numsIndex[i][0] = nums[i];
            numsIndex[i][1] = i;
        }
        Arrays.sort(numsIndex, Comparator.comparingInt(a -> a[0]));

        int l = 0;
        int r = nums.length - 1;

       while(l<r){
        int sum = numsIndex[l][0] + numsIndex[r][0];

        if (sum == target) {
            return new int[] { numsIndex[l][1], numsIndex[r][1] };
        }
        if (sum > target)
            r--;
        if (sum < target)
            l++;
    }
    return null;
}}
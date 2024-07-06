//재귀
class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        index = searchTarget(nums, target, 0, nums.length-1);
        return index;
    }

    int searchTarget(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1; 
        }
        int mid = left+ (right - left) / 2;
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return searchTarget(nums, target, left, mid - 1);
        else return searchTarget(nums, target, mid + 1, right);
    }
}
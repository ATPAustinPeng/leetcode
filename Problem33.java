public class Problem33 {
    // just a list of some failed test cases... before I got it to work
    // i still don't understand why some lines have <= over < and why left <= right
    // not left < right...
    public static void main(String[] args) {
        Problem33 p33 = new Problem33();
        int[] nums = new int[] { 1, 3 };
        int target = 3;
        // int[] nums = new int[] { 3, 1 };
        // int target = =1;
        // int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 3;
        // int[] nums = new int[] { 1 };
        // int target = 1;
        System.out.println("result: " + p33.search(nums, target));
    }

    public int search(int[] nums, int target) {
        // essentially binary search
        // one side of the array will be sorted in increasing order
        // just determine which side the target is located in
        // nums[mid] < nums[right] -> right side sorted
        // right = mid
        // nums[left] < nums[mid] -> left side sorted
        // left = mid + 1

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
}
package dynamicprogramming;

public class LeetCode_416 {
    public static void main(String[] args) {
        LeetCode_416 leetCode_416 = new LeetCode_416();
        int[] arr = {1, 1, 1, 1};
        boolean b = leetCode_416.canPartition(arr);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] status = new boolean[len][sum + 1];
        return dfs(nums, status,target);
    }

    public boolean dfs(int[] nums,boolean[][] status,int target) {
        status[0][0] = true;
        status[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >=0; j--) {
                if (status[i - 1][j]) {
                    status[i][j] = status[i - 1][j];
                }
            }
            for (int j = target - nums[i]; j >= 0; j--) {
                if (status[i - 1][j]) {
                    status[i][j + nums[i]] = true;
                }
            }

        }
        return status[nums.length - 1][target];
    }
}

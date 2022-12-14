
import java.util.stream.IntStream;

/*
TODO Leetcode problem: 198. House Robber
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        int[] nums3 = {2,1};
        int[] nums4 = {1,2};
        int[] nums5 = {2,1,1,2}; // Have to be 4, counting the index 0 and 3

        int result = rob(nums1);
        System.out.println(result);

        int result2 = rob(nums2);
        System.out.println(result2);

        int result3 = rob(nums3);
        System.out.println(result3);

        int result4 = rob(nums4);
        System.out.println(result4);

        int result5 = rob(nums5);
        System.out.println(result5);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
    public static int robFirstTry(int[] nums) {
        long path1 = IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 0)
                .mapToLong(i -> nums[i])
                .sum();

        long path2 = IntStream.range(0, nums.length)
                .filter(i -> i % 2 != 0)
                .mapToLong(i -> nums[i])
                .sum();

        return (int) Math.max(path1, path2);
    }
}

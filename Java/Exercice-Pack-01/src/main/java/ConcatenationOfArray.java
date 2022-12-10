import java.util.Arrays;

/*
TODO Leetcode exercise: 1929. Concatenation of Array
 */
public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int[] nums2 = {1,3,2,1};
        int[] nums3 = {7, 9, 5, 10, 15, 8, 9, 6};

        int[] result1 = getConcatenation(nums1);
        System.out.println(Arrays.toString(result1));

        int[] result2 = getConcatenation(nums2);
        System.out.println(Arrays.toString(result2));

        int[] result3 = getConcatenation(nums3);
        System.out.println(Arrays.toString(result3));
    }

    public static int[] getConcatenation(int[] nums) {
        int doubleCapacity = 2 * nums.length;
        int[] ans = new int[doubleCapacity];

        /*
        This approach below using a sequence of = I don't knew that can do this, is the first time
        that I saw this approach, until now I only knew that we only can assign one = per condition
        but seems that it can be a chain of =.
         */
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[nums.length + i] = nums[i];
        }
        return ans;
    }
}

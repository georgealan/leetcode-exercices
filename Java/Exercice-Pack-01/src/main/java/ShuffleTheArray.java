import java.util.Arrays;

/**
 * TODO Leetcode exercise nº 1470. Shuffle the Array
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums1 = {2,5,1,3,4,7}; // [2, 3, 5, 4, 1, 7]
        int[] nums2 = {1,2,3,4,4,3,2,1};
        int[] nums3 = {1,1,2,2};

        int[] result1 = shuffle(nums1, 3);
        System.out.println("Result array1: " + Arrays.toString(result1));

        int[] result3 = shuffle(nums3, 2);
        System.out.println("Result array1: " + Arrays.toString(result3));

        int[] result2 = shuffle(nums2, 4);
        System.out.println("Result array1: " + Arrays.toString(result2));
    }

    static int[] shuffle(int[] nums, int n) {
        System.out.print("Array before modified: " + Arrays.toString(nums));
        int[] result = new int[nums.length];
        int x = 0;
        int y = 1;
        int j = n;

        for (int i = 0; i < n; i++) {
            result[x] = nums[i];
            result[y] = nums[j];
            x += 2;
            y += 2;
            j++;
        }
        return result;
    }
}

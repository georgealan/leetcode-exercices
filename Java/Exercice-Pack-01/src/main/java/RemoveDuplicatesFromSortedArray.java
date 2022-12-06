import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2 = {1, 1, 2};

        removeDuplicates(nums);
        removeDuplicates(nums2);
    }

    static int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[index] = nums[i];
            index++;
        }

        System.out.println(index);
        System.out.println(Arrays.toString(nums));
        return index;
    }
}

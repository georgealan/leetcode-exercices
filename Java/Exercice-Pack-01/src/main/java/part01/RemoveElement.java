package part01;

import java.util.Arrays;

/**
 * TODO Leetcode exercise nº 27. Remove Element
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = {3,2,2,3};
        int[] nums2 = {0,1,2,2,3,0,4,2};

        int result1 = removeElement(nums1, 3);
        System.out.println(result1);

        int result2 = removeElement(nums2, 2);
        System.out.println(result2);
    }

    static int removeElement(int[] nums, int val) {
        System.out.println("Array before modification = " + Arrays.toString(nums));

        int index = 0;
        for (int number : nums) {
            if (number != val) {
                nums[index] = number;
                index++;
            }
        }

        System.out.println("Array after modification = " + Arrays.toString(nums));
        return index;
    }
}

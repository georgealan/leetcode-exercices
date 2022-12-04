public class MinimumAverageDifference {
    public static void main(String[] args) {
        int[] nums1 = {2,5,3,9,5,3};
        int[] nums2 = {0};
        int[] nums3 = {59929,41441,98548,9508,1220,60068,81416,73792,13104,9602,70468,27938,66307,34760,17361,45745,9016,32018,48434,37353,20676,57433,71200,92214,39651,80173,85717,69329,1025,87538,72692,39240,86951,13577,17601,34664,15129,14029,97310,72512,20374,35697,36930,79276,27607,94058,44942,26685,90111,83130,34600,66244,64032,32914,6658,12097,83136,55518};

        int result1 = minimumAverageDifference(nums1);
        int result2 = minimumAverageDifference(nums2);
        int result3 = minimumAverageDifference(nums3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    static int minimumAverageDifference(int[] nums) {
        int arrayLength = nums.length;
        int index = -1;
        int minAverageDifference = Integer.MAX_VALUE;
        int calcAverage = 0;
        long totalSum = 0;

        // This approach below solve the problem which I have with stream.sum()
        for (int i = 0; i < arrayLength; i++) {
            totalSum += nums[i];
        }
        /*
        When I use stream.sum() in this code below:

        long totalSum = Arrays.stream(nums).sum();

        occurred a problem with a large number of elements in the array, but I change the approach
        and use imperative programming otherwise declarative functional with stream.sum(), and solve
        the problem. If the array have a large number of items seems that stream.sum() don't work
        greater than old way. Investigate this later.
         */

        long sumFromStart = 0;
        long sumFromEnd = totalSum;

        for (int i = 0; i < nums.length; ++i) {
            sumFromStart += nums[i];
            sumFromEnd = totalSum - sumFromStart;

            calcAverage = (int) Math.abs(
                (sumFromStart / (i + 1)) -
                ((i == arrayLength - 1) ? 0 : (sumFromEnd / (arrayLength - i - 1)))
            );

            if (calcAverage < minAverageDifference) {
                minAverageDifference = calcAverage;
                index = i;
            }
        }
        return index;
    }
}

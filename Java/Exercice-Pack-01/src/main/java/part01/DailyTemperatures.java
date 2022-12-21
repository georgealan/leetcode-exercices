package part01;

import java.util.Arrays;

/*
TODO Leetcode exercise: 739. Daily Temperatures
 Given an array of integers temperatures represents the daily temperatures,
 return an array answer such that answer[i] is the number of days you have to wait
 after the ith day to get a warmer temperature. If there is no future day for which
 this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temps1 = {73,74,75,71,69,72,76,73};
        int[] temps2 = {30,40,50,60};
        int[] temps3 = {30,60,90};
        int[] temps4 = {89,62,70,58,47,47,46,76,100,70}; // Expected: [8,1,5,4,3,2,1,1,0,0]
        int[] temps5 = {98,98,98,98,98,98,98,98}; // Expected: [0,0,0,0,0,0,0,0] Time Limit Exceeded in Leetcode

        /*int[] result1 = dailyTemperatures(temps1);
        System.out.println(Arrays.toString(result1));

        int[] result2 = dailyTemperatures(temps2);
        System.out.println(Arrays.toString(result2));

        int[] result3 = dailyTemperatures(temps3);
        System.out.println(Arrays.toString(result3));*/

        int[] result5 = dailyTemperaturesFirstApproach(temps5);
        System.out.println(Arrays.toString(result5));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        // TODO Solve this bug later.
        return result;
    }

    /**
     *
     * @param temperatures
     * @return
     * This approach had an issue in Leetcode system, when the input array have many equals numbers, a
     * huge array of equals numbers, like this: [99,99,99,99,99,99,99...] Leetcode display a error:
     * Time Limit Exceeded.
     */
    public static int[] dailyTemperaturesFirstApproach(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            int j = i;
            if (temperatures[i] < temperatures[i + 1]) {
                result[i] = (i + 1) - i;
            } else if (temperatures[i] >= temperatures[i + 1]) {
                while (j < temperatures.length - 1 && temperatures[i] >= temperatures[j + 1]) {
                    j++;
                }
                if (j == temperatures.length - 1) { continue; }
                result[i] = (j + 1) - i;
            }
        }
        return result;
    }
}

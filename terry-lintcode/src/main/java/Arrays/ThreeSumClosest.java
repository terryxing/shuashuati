package Arrays;

import java.util.Arrays;

/**
 * Created by xingtianyi on 11/28/17.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {

        ThreeSumClosest x = new ThreeSumClosest();

        int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1,2};

        int result = x.threeSumClosest(nums, 7);

    }

    public int threeSumClosest(int[] numbers, int target) {

        int result = 0;

        if (numbers == null || numbers.length < 3) {
            return -1;
        }
        int len = numbers.length;
        Arrays.sort(numbers);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len - 2; i++) {

            int first = numbers[i];

            int p1 = i + 1;
            int p2 = len - 1;

            while (p1 < p2) {

                int sum = first + numbers[p1] + numbers[p2];

                int dif = Math.abs(sum-target);

                if (sum == target) {
                    return sum;
                }

                if (dif < min) {
                    result = sum;
                    min = dif;
                }

                if (sum > target) {
                    p2--;
                } else {
                    p1++;
                }
            }

        }

        return result;

    }

}

package basicalgorithmsI;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /**
     * 11/30
     *
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            ranges.add(getRange((long) lower - 1, (long) upper + 1));
            return ranges;
        }

        if (getRange((long) lower - 1, nums[0]) != null) {
            ranges.add(getRange((long) lower - 1, nums[0]));
        }


        for (int i = 0; i <= nums.length - 2; i++) {
            if (getRange(nums[i], nums[i + 1]) != null) {
                ranges.add(getRange(nums[i], nums[i + 1]));
            }
        }

        if (getRange(nums[nums.length - 1], (long) upper + 1) != null) {
            ranges.add(getRange(nums[nums.length - 1], (long) upper + 1));
        }

        return ranges;
    }

    private String getRange(long left, long right) {
        if (left == right || left + 1 == right) {
            return null;
        }

        if (left + 2 == right) {
            return "" + (left + 1);
        }

        return "" + (left + 1) + "->" + (right - 1);
    }
}

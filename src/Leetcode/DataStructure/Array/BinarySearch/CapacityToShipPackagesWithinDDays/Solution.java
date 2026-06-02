package Leetcode.DataStructure.Array.BinarySearch.CapacityToShipPackagesWithinDDays;

/**
 * Left should be the weight of the heaviest single item, and right should be the total weight.
 *
 * @since 30 / 05 / 2026
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // initialize left and right pointer
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // find left endpoint
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (costDays(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // calculate cost days
    public int costDays(int[] weights, int capacity) {
        int days = 0;
        int load = 0;

        for (int weight : weights) {
            if (load + weight <= capacity) {
                load += weight;
                continue;
            } else {
                days++;
                load = weight;
            }
        }

        days++;

        return days;
    }
}

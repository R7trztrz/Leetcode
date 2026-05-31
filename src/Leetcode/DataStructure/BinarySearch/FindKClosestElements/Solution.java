package Leetcode.DataStructure.BinarySearch.FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @since 31 / 05 / 2026
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // get the index of x
        int p = findX(arr, x);

        // open intervals
        // left = last element < x
        // right = first element >= x
        int left = p - 1;
        int right = p;

        // expand
        while (right - left - 1 < k) {
            // avoid out of bounds
            if (left == -1) {
                right++;
            } else if (right == arr.length) {
                left--;
            } else if (x - arr[left] > arr[right] - x) {
                right++;
            } else {
                left--;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = left + 1; i < right; i++) {
            answer.add(arr[i]);
        }

        return answer;
    }

    // find first element >= x
    public int findX(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

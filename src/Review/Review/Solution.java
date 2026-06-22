package Review.Review;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int p = findX(arr, x);
        int left = p - 1;
        int right = p;

        ArrayList<Integer> answer = new ArrayList<>();

        while (right - left - 1 < k) {
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

        for (int i = left + 1; i < right; i++) {
            answer.add(arr[i]);
        }

        return answer;
    }

    public int findX (int[] arr, int x) {
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

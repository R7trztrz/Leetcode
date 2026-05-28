package Leetcode.DataStructure.BinarySearch.KokoEatingBananas;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // initialize right and left pointer
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (eatingTime(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // calculate eating time
    long eatingTime(int[] piles, int speed) {
        long time = 0;

        for (int pile : piles) {
            time += pile / speed;

            if (pile % speed > 0) {
                time++;
            }
        }

        return time;
    }
}

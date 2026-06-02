package Leetcode.DataStructure.Array.DiffArray.CarPooling;

/**
 * With the difference array diff, we can quickly increase or decrease a range of elements.
 * <p>
 * If every element in the result array (seats) is less than capacity, all passengers can be transported
 * without overloading.
 * Time complexity: O(n)
 *
 * @since 13 / 05 / 2026
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // find last stop
        int stop = 0;

        for (int[] i : trips) {
            if (i[2] > stop) {
                stop = i[2];
            }
        }

        // build diff array
        int[] seats = new int[stop];
        int[] diff = new int[stop];

        diff[0] = seats[0];
        for (int i = 1; i < stop; i++) {
            diff[i] = seats[i] - seats[i - 1];
        }

        // calculate seats capacity
        for (int[] i : trips) {
            // number of people
            int number = i[0];
            // from x to y
            int x = i[1];
            int y = i[2] - 1;

            diff[x] += number;
            if (y + 1 < stop) {
                diff[y + 1] -= number;
            }
        }

        // restore seats
        seats[0] = diff[0];
        for (int i = 1; i < stop; i++) {
            seats[i] = diff[i] + seats[i - 1];
        }

        for (int i : seats) {
            if (i > capacity) {
                return false;
            }
        }

        return true;
    }
}
